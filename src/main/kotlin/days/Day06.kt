package days

class Day06 {
    companion object {

        fun part1(input: String): Int {
            for (i in 4 until input.length) {
                val last4 = input.substring(i - 4, i)

                println("$last4 == ${last4.toList().distinct().joinToString("")}")
                if (last4.toList() == last4.toList().distinct()) {
                    return i
                }
            }
            return -1
        }

        fun part2(input: String): Int {
            for (i in 14 until input.length) {
                val last14 = input.substring(i - 14, i)

                println("$last14 == ${last14.toList().distinct().joinToString("")}")
                if (last14.toList() == last14.toList().distinct()) {
                    return i
                }
            }
            return -1
        }

    }
}