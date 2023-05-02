#!/usr/bin/bash
git add .
if [ -z "$mensagem" ];
then
	git commit -m "salvando"
	echo "Tentativa de envio"
else
	git commit -m "salvando - $mensagem"
	echo "Tentativa de envio realizada - $mensagem"
fi
git push origin $nome

