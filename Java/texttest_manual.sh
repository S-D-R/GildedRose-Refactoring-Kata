#!/bin/bash

java -classpath target/classes:target/test-classes com.gildedrose.TexttestFixture 30 > output.txt

if cmp --silent -- "output.txt" "../texttests/ThirtyDays/stdout.gr"; then
  echo "output matches texttests output"
else
  echo "output doesn't match texttests output"
fi

rm output.txt
