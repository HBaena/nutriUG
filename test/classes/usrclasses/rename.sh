#! /bin/bash
#ls lista el contenido de la carpeta
#lista sólo los .jpg | sed busca los jpg
FILES=$(ls *.jad | sed 's/.jad//' )
for i in $FILES; do
    echo $i'.jpg -->' $i'.png'
    cp $i'.jad' 2> /dev/null | pnmtopng > $i'.java' 
done