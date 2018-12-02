package day2

import fileoperations.readFile

fun main(args: Array<String>) {
    val barcodes = readFile("src/day2/input.txt")

    calculateControlSum(barcodes)
    findCommonPart(barcodes)
}

fun calculateControlSum(barcodes: List<String>) {
    var counterFor2 = 0
    var counterFor3 = 0

    barcodes.forEach { barcode ->
        val counterForLetter = barcode.groupingBy { it }.eachCount()

        if (counterForLetter.values.contains(2)) {
            counterFor2++
        }
        if (counterForLetter.values.contains(3)) {
            counterFor3++
        }
    }

    val checkSum = counterFor2 * counterFor3
    println("Part 1. checksum: $checkSum")
}

fun findCommonPart(barcodes: List<String>) {
    barcodes.forEachIndexed { index,
                              barcode ->
        barcodes.subList(index + 1, barcodes.size)
            .forEach { barcodeToCompare ->
                compareBarcodes(barcode, barcodeToCompare)
            }
    }
}

private fun compareBarcodes(barcode1: String, barcode2: String) {
    val commonPart = barcode1.filterIndexed { index, letter ->
        letter == barcode2[index]
    }
    if (commonPart.length == barcode1.length - 1) {
        print("Part 2. result: $commonPart")
    }
}