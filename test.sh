#!/bin/bash

SRC_FOLDER="src"
INPUT_FOLDER="in"
OUTPUT_FOLDER="out"
RESULT_FOLDER="$OUTPUT_FOLDER/results"

mkdir -p "$RESULT_FOLDER"

javac "$SRC_FOLDER"/*.java -d "$SRC_FOLDER/bin"

for input_file in "$INPUT_FOLDER"/*.in; do
    input_name=$(basename "$input_file" .in)
    result_file="$RESULT_FOLDER/$input_name.out"

    echo "=== Running $input_name ==="

    java -cp "$SRC_FOLDER/bin" Algo_test "$input_file" > "$result_file"

    echo ""
done