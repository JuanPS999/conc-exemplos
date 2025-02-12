cd ~/Documentos/conc-exemplos/ || exit

git add .
git commit -m "Backup automático: $(date)"
git push origin master
