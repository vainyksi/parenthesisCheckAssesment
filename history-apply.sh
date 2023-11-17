#!/bin/bash

if [[ $# -eq 0 ]] ; then
    echo 'missing parameter'
    exit 0
fi

NUM=$1
echo 'applying patch '$NUM

git cherry-pick --no-commit -X theirs ebcf073fd3fbdb288c0f0a1d17a605aa9b6b17f6 
rm src/test/java/org/example/parenthesis/check/assesment/ParenthesisCheck.java
rm src/test/java/org/example/parenthesis/check/assesment/parenthesisCheck.java
git apply --whitespace=fix intellij_reverse_local_history/local_history$NUM.patch
git add src/test/java/org/example/parenthesis/check/assesment/ParenthesisCheck.java 
git add src/test/java/org/example/parenthesis/check/assesment/parenthesisCheck.java 
git add src/test/java/org/example/parenthesis/check/assesment/ParenthesisCheckTest.java 
git commit -m "history$NUM"

