package fileoperations

import java.io.File

fun readFileAndParseToInt(fileName: String): List<Int> = readFile(fileName)
    .map { line -> Integer.valueOf(line) }

fun readFile(fileName: String): List<String> = File(fileName).readLines()