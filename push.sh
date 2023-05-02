#!/usr/bin/bash
BRANCH=$(git branch --show-current)
git add .
git commit -m "salvando"
echo "Adicionando na branch $BRANCH"
git push origin $BRANCH
echo "Tentativa de envio realizada!"


