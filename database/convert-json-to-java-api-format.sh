#!/bin/bash

json_file_temp1=temp1.json
json_file_temp2=temp2.json
json_file=open-trivia-java-api.json

[ -e $json_file_temp1 ] && rm -f $json_file_temp1
[ -e $json_file_temp2 ] && rm -f $json_file_temp2

grep category open-trivia.json > $json_file_temp1

i=1
total=$(cat $json_file_temp1 | wc -l)
while read line; do
  echo "Processing line $i from $total..."
  echo $(echo $line | sed "s/^{/{ \"id\": $i, /g" | sed "s/}/},/g") >> $json_file_temp2
  i=$((i + 1));
done < $json_file_temp1


# Remove last ,
number_of_head_lines=$(cat $json_file_temp2 | wc -l)
number_of_head_lines=$(($number_of_head_lines - 1))

head -n $number_of_head_lines $json_file_temp2 > $json_file
tail -n 1 $json_file_temp2 | sed 's/},/}/g' >> $json_file


# Append [ to the beginning and ] at the end
sed -i '1s/^/[\n/' $json_file
sed -i '$a]' $json_file


# Remove temp files
rm -f $json_file_temp1 $json_file_temp2
