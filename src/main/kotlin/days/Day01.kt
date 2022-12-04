package days

class Day01 {
    companion object {
        fun part1(input: List<String>): Int {
            val elves = mutableListOf(0)
            input.forEach { line ->
                if (line.isBlank()) elves.add(0)
                else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
            }
            return elves.max()
        }

        fun part2(input: List<String>): Int {
            val elves = mutableListOf(0)
            input.forEach { line ->
                if (line.isBlank()) elves.add(0)
                else elves[elves.lastIndex] += line.toIntOrNull() ?: 0
            }
            return elves.sortedDescending().subList(0, 3).sum()
        }
    }
}
