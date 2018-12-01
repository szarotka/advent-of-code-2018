package day1

import fileoperations.readFileAndParseToInt

fun main(args: Array<String>) {
    val coefficients = readFileAndParseToInt("src/day1/input.txt")

    calculateFrequency(coefficients)

    findTwiceFrequency(coefficients)
}

fun findTwiceFrequency(coefficients: List<Int>) {
    var currentSum = 0
    var historyOfFrequency = mutableListOf<Int>()
    var loopCounter = 0

    while (true) {
        coefficients
            .forEachIndexed { index,
                              coefficient ->
                currentSum += coefficient
                historyOfFrequency.add(currentSum)

                if (historyOfFrequency
                        .subList(0, loopCounter * coefficients.size + index)
                        .contains(currentSum)
                ) {
                    println("Step 2. Twice frequency: $currentSum")
                    return
                }
            }
        loopCounter++
    }
}

fun calculateFrequency(frequencies: List<Int>) {
    val resultFrequency = frequencies.sum()
    println("Step 1. Frequency: $resultFrequency")
}