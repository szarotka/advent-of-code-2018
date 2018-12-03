package day3

import fileoperations.readFile

fun main(args: Array<String>) {
    val areas = initAreas()

    val occupiedFields = mutableSetOf<Pair<Int, Int>>()
    val commonFields = mutableSetOf<Pair<Int, Int>>()

    areas.forEach { area ->
        for (left in area.left until area.left + area.width) {
            for (top in area.top until area.top + area.height) {
                val field = Pair(left, top)
                if (occupiedFields.contains(field)) {
                    commonFields.add(field)
                }
                occupiedFields.add(field)
            }
        }
    }
    println("Part 1.: " + commonFields.size)

    //part 2.
    areas.forEach { area ->
        var collision = false
        for (left in area.left until area.left + area.width) {
            for (top in area.top until area.top + area.height) {
                val field = Pair(left, top)
                if (commonFields.contains(field)) {
                    collision = true
                }
            }
        }
        if (!collision) {
            println("Part 2.: " + area.id)
        }
    }
}

fun initAreas(): List<Area> {
    val claims = readFile("src/day3/input.txt")

    val regex = """#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""".toRegex()

    return claims.map { claim ->
        val matchResult = regex.find(claim)
        val (id: String, left: String, top: String, width: String, height: String) = matchResult!!.destructured
        Area(
            Integer.valueOf(id),
            Integer.valueOf(left),
            Integer.valueOf(top),
            Integer.valueOf(width),
            Integer.valueOf(height)
        )
    }
}
