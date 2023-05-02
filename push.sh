#!/usr/bin/bash
git add .
echo "Digite o nome da branch"
read BRANCH
if [ -z $MSG ];
then
	git commit -m "salvando"
	echo "Tentativa de envio"
else
	git commit -m "salvando - $MSG"
	echo "Tentativa de envio realizada - $MSG"
fi
git push origin $BRANCH

