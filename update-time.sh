#!/bin/bash


update_commit_time () {
	echo $1

  if [[ $# -eq 0 ]] ; then
      echo 'missing parameter'
      exit 0
  fi


  TIME=$1
  echo $TIME

  git commit --am --date="Wed Nov 1 2023 $TIME +0200" --no-edit
  GIT_COMMITTER_DATE="Wed Nov 1 2023 $TIME +0200" git commit --amend --no-edit
  git rebase --continue

}

#update_commit_time $1

update_commit_time 21:26:00 # 0
update_commit_time 21:29:00 # 1
update_commit_time 21:29:00 # 2
update_commit_time 21:29:00 # 3
  # 4 - skip
update_commit_time 21:30:00 # 5
update_commit_time 21:32:00 # 6
update_commit_time 21:34:00 # 7
update_commit_time 21:34:00 # 8
update_commit_time 21:40:00 # 9
update_commit_time 21:42:00 # 10
update_commit_time 21:43:00 # 11
update_commit_time 21:44:00 # 12
update_commit_time 21:48:00 # 13
update_commit_time 21:50:00 # 14
update_commit_time 21:50:00 # 15
update_commit_time 21:55:00 # 16
update_commit_time 21:56:00 # 17
update_commit_time 21:58:00 # 18
update_commit_time 21:58:00 # 19
update_commit_time 21:59:00 # 20
update_commit_time 21:59:00 # 21
update_commit_time 21:59:00 # 22
update_commit_time 22:00:00 # 23
update_commit_time 22:01:00 # 24
update_commit_time 22:01:00 # 25
update_commit_time 22:04:00 # 26
update_commit_time 22:04:00 # 27
update_commit_time 22:08:00 # 28
update_commit_time 22:21:00 # 29
update_commit_time 22:21:00 # 30
update_commit_time 22:22:00 # 31
update_commit_time 22:23:00 # 32
update_commit_time 22:23:00 # 33
update_commit_time 22:23:00 # 34
  # 35 - skip
update_commit_time 22:24:00 # 36
update_commit_time 22:24:00 # 37
update_commit_time 22:25:00 # 38
update_commit_time 22:26:00 # 39
update_commit_time 22:26:00 # 40
update_commit_time 22:27:00 # 41
update_commit_time 22:27:00 # 42
update_commit_time 22:28:00 # 43
update_commit_time 22:29:00 # 44
update_commit_time 22:29:00 # 45
update_commit_time 22:29:00 # 46
update_commit_time 22:29:00 # 47
update_commit_time 22:30:00 # 48
update_commit_time 22:30:00 # 49
update_commit_time 22:30:00 # 50
update_commit_time 22:31:00 # 51
update_commit_time 22:31:00 # 52
update_commit_time 22:32:00 # 53
update_commit_time 22:32:00 # 54
update_commit_time 22:38:00 # 55
update_commit_time 22:38:00 # 56
update_commit_time 22:39:00 # 57
update_commit_time 22:39:00 # 58
update_commit_time 22:39:00 # 59
update_commit_time 22:39:00 # 60
update_commit_time 22:39:00 # 61
update_commit_time 22:41:00 # 62
update_commit_time 22:42:00 # 63
update_commit_time 22:42:00 # 64
update_commit_time 22:42:00 # 65
update_commit_time 22:45:00 # 66
update_commit_time 22:45:00 # 67
update_commit_time 22:47:00 # 68
update_commit_time 22:49:00 # 69
update_commit_time 22:49:00 # 70
update_commit_time 22:49:00 # 71
update_commit_time 22:49:00 # 72
update_commit_time 22:51:00 # 73
update_commit_time 22:51:00 # 74
update_commit_time 22:51:00 # 75
update_commit_time 22:52:00 # 76
update_commit_time 22:52:00 # 77
update_commit_time 22:53:00 # 78
update_commit_time 22:53:00 # 79
update_commit_time 22:55:00 # 80
update_commit_time 22:55:00 # 81
update_commit_time 22:56:00 # 82
  # 83 - skip
update_commit_time 23:00:00 # 84
update_commit_time 23:00:00 # 85
update_commit_time 23:01:00 # 86
update_commit_time 23:01:00 # 87
update_commit_time 23:01:00 # 88
update_commit_time 23:01:00 # 89





