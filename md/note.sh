#!/bin/sh

name=$1

f_md=$name.md
f_pdf=$name.pdf

#echo $f_csv
#echo $f_pdf

pandoc -s -i \
    --pdf-engine=xelatex \
    -V geometry:"top=1cm, bottom=1cm, left=1cm, right=1cm" \
    -V colorlinks \
    -V urlcolor=NavyBlue \
    -o $f_pdf $f_md +RTS -Ksize -RTS
