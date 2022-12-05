package days

import includes

class Day04 {
    companion object {

        fun part1(input: List<String>): Int {
            return input.count { line ->
                val ranges = line.split(',').map { rangeString ->
                    IntRange(
                        rangeString.substringBefore('-').toInt(),
                        rangeString.substringAfter('-').toInt()
                    )
                }

                ranges.first().includes(ranges.last()) || ranges.last().includes(ranges.first())
            }
        }

        private fun ClosedRange<Int>.overlaps(other: ClosedRange<Int>): Boolean {
            return contains(other.start) || contains(other.endInclusive)
        }

        fun part2(input: List<String>): Int {
            return input.count { line ->
                val ranges = line.split(',').map { rangeString ->
                    IntRange(
                        rangeString.substringBefore('-').toInt(),
                        rangeString.substringAfter('-').toInt()
                    )
                }

                ranges.first().overlaps(ranges.last()) || ranges.last().overlaps(ranges.first())
            }
        }

    }
}
