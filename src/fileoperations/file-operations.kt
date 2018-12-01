package fileoperations

import java.io.File

fun readFile(fileName: String): List<String>
        = File(fileName).readLines()