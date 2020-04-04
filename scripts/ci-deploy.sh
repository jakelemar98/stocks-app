#! /bin/bash
# exit script when any command ran here returns with non-zero exit code
set -e

GITHUB_SHA=$1
DEPLOYMENT=$2

# We must export it so it's available for envsubst
export GITHUB_SHA=$1

# since the only way for envsubst to work on files is using input/output redirection,
#  it's not possible to do in-place substitution, so we need to save the output to another file
#  and overwrite the original with that one.
envsubst <./k8s/$2/values.yaml >./k8s/$2/values.yaml.out
mv ./k8s/$2/values.yaml.out ./k8s/$2/values.yaml

kubectl config set-context prod --namespace=production \
  --cluster=gke_stocks-app-email_us-central1_stocks-cluster \
  --user=gke_stocks-app-email_us-central1_stocks-cluster


kubectl config use-context $3

curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh

helm install $2 ./k8s/$2
