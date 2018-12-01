package day1

import fileoperations.readFile
import kotlin.streams.toList

fun main(args: Array<String>) {
    val frequencies = readFile("src/day1/input.txt")

    calculateFrequency(frequencies)

    val coefficients = frequencies.stream()
        .map { frequency -> Integer.valueOf(frequency) }
        .toList()

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
                    println("Step 2. Twice for frequency: $currentSum")
                    return
                }
            }
        loopCounter++
    }
}

fun calculateFrequency(frequencies: List<String>) {
    val resultFrequency = frequencies.sumBy { frequency -> Integer.valueOf(frequency) }
    println("Step 1. Result frequency: $resultFrequency")
}