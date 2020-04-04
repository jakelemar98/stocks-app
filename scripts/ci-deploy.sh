#! /bin/bash
# exit script when any command ran here returns with non-zero exit code
set -e

GITHUB_SHA=$1
DEPLOYMENT=$2

# We must export it so it's available for envsubst
export GITHUB_SHA=$1
export BRANCH=$7
# since the only way for envsubst to work on files is using input/output redirection,
#  it's not possible to do in-place substitution, so we need to save the output to another file
#  and overwrite the original with that one.
envsubst <./k8s/$2/$3.yaml >./k8s/$2/$3.yaml.out
mv ./k8s/$2/$3.yaml.out ./k8s/$2/$3.yaml

kubectl config set-context $4 --namespace=$5 \
  --cluster=gke_stocks-app-email_us-central1_stocks-cluster \
  --user=gke_stocks-app-email_us-central1_stocks-cluster


kubectl config use-context $4

curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh

if [ $6 = "redis" ] ; then
    helm upgrade --install redis ./k8s/redis || true 
fi

helm upgrade --install $2 ./k8s/$2 || true
