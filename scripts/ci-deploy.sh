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
envsubst <./k8s/$2-deployment.yml >./k8s/$2/$2-deployment.yml.out
mv ./k8s/$2-deployment.yml.out ./k8s/$2/$2-deployment.yml

kubectl apply -f ./k8s/$2/$2-deployment.yml
