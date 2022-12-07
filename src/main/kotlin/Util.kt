fun answer(solution: Any) {
    val solutionText = solution.toString()
    println("*${"-".repeat(solutionText.length + 2)}*")
    println("| $solutionText |")
    println("*${"-".repeat(solutionText.length + 2)}*")
}

fun String.columns(): List<String> {
    val columns = mutableListOf<String>()
    for (i in 0 until lines().maxOf { it.length }) {
        columns.add(lines().map { it.getOrNull(i) ?: "" }.joinToString(""))
    }
    return columns
}

fun String.words(): List<String> {
    return split(" ")
}

fun IntRange.includes(other: IntRange): Boolean {
    return contains(other.first) && contains(other.last)
}
