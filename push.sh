git add .
if [ conteudo != "" ];
then
	git commit -m "salvando - $conteudo"
	echo "Tentativa de envio de $conteudo"
else
	git commit -m "salvando"
	echo "Tentativa de envio realizada"
fi
git push origin $nome

