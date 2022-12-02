package days

fun day01(input: List<String>): Int {
    val elves = mutableListOf(0)
    input.forEach { line ->
        if (line.isBlank()) elves.add(0)
        else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
    }
    return elves.max()
}

fun day01p2(input: List<String>): Int {
    val elves = mutableListOf(0)
    input.forEach { line ->
        if (line.isBlank()) elves.add(0)
        else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
    }
    return elves.sortedDescending().subList(0, 3).sum()
}
