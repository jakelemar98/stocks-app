#!/bin/bash
echo "here"
printf '%s\n' "${PWD##*/}" # to print to stdout

git add -A
git commit --amend --no-edit
git status