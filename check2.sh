#! /bin/bash


for dire in ./test/*
do

  difs="$(java -classpath 'C:\Users\filip\IdeaProjects\ComputingTheory-lab4\out\production\ComputingTheory-lab4' Parser < $dire/test.in | diff $dire/test.out -)"

	if [ "$difs" = "" ];
	then
		echo "$dire : [OK]"
	else
		echo "$dire : "
    echo "$difs"
	fi

done



