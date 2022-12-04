package days

class Day03 {
    companion object {

        private fun Char.getPriority(): Int {
            return if (this == toLowerCase()) this - 'a' + 1
            else this - 'A' + 27
        }

        fun part1(input: List<String>): Int {
            var allWrongItems = ""
            input.forEach { backpack ->
                val part1 = backpack.substring(0 until backpack.length / 2)
                val part2 = backpack.substring(backpack.length / 2)
                var wrongItems = ""

                part1.forEach { part1c ->
                    val c = part2.firstOrNull { it == part1c }
                    if (c != null && !wrongItems.contains(c)) wrongItems += c
                }

                allWrongItems += wrongItems
            }
            println(allWrongItems)
            return allWrongItems.map { it.getPriority() }.sum()
        }

        fun part2(input: List<String>): Int {
            val groups = input.chunked(3)
            var badges = ""

            groups.forEach { group ->
                badges += group.first().first { badge ->
                    group[1].contains(badge) && group[2].contains(badge)
                }
            }

            return badges.sumOf { it.getPriority() }
        }

    }
}