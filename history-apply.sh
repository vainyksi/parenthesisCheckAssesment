#!/bin/bash

# for i in {1..90} ; do [ $i != 4 ] && ./history-apply.sh $i; done


remove_file_if_exist() {
	FILE=$1
	if [ -e $FILE ] ; then
		rm $FILE;
		echo $FILE "removed";
	fi
}

apply_local_history_patch() {

  if [[ $# -eq 0 ]] ; then
      echo 'missing parameter'
      exit 0
  fi

  NUM=$1
  echo 'applying patch '$NUM

  git cherry-pick --no-commit -X theirs ebcf073fd3fbdb288c0f0a1d17a605aa9b6b17f6
  remove_file_if_exist src/test/java/org/example/parenthesis/check/assesment/ParenthesisCheck.java
  remove_file_if_exist src/test/java/org/example/parenthesis/check/assesment/parenthesisCheck.java
  git apply --whitespace=fix intellij_reverse_local_history/local_history$NUM.patch
  git add .
  git commit -m "history$NUM"
}




for i in {0..90} ; do [ $i != 4 ] && apply_local_history_patch $i; done
