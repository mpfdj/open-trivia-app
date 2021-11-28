#!/bin/bash

json_file_temp=temp.json
json_file=open-trivia-java-api.json

grep category open-trivia.json > $json_file_temp

touch $json_file
cat /dev/null > $json_file

i=1
total=$(wc -l $json_file_temp)

while read line; do
  echo "Processing line $i from $total"
  echo $(echo $line | sed "s/{/{ \"id\": $i, /g" | sed "s/}/},/g") >> $json_file
  i=$((i+1));
done < $json_file_temp

rm -f $json_file_temp

sed -i '1s/^/[\n/' $json_file
sed -i '$a]' $json_file