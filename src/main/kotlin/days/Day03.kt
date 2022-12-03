package days

fun Char.getPriority(): Int {
    return if (this == toLowerCase()) this - 'a' + 1
    else this - 'A' + 27
}

fun day03(input: List<String>): Int {
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

fun day03p2(input: List<String>) {

}