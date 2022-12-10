package days

class Day08 {
    companion object {

        class Tree(
            val height: Int,
        ) {
            var x: Int = -1
            var y: Int = -1

            fun setCoords(x: Int, y: Int) {
                this.x = x
                this.y = y
            }
        }

        class Forest(
            var width: Int,
            var trees: MutableList<Tree>,
        ): Collection<Tree> {
            override val size: Int
                get() = trees.size

            override fun isEmpty(): Boolean {
                return trees.isEmpty()
            }

            override fun iterator(): Iterator<Tree> {
                return trees.iterator()
            }

            override fun containsAll(elements: Collection<Tree>): Boolean {
                return trees.containsAll(elements)
            }

            override fun contains(element: Tree): Boolean {
                return trees.contains(element)
            }

            val length: Int
                get() = (trees.size / width)

            init {
                for (x in 0 until width) {
                    for (y in 0 until length) {
                        get(x, y)?.setCoords(x, y)
                    }
                }
            }

            fun isTreeVisible(x: Int, y: Int): Boolean {
                // Tree is on edge
                if (x == 0 || y == 0 || x % (width - 1) == 0 || y % (length - 1) == 0) {
                    return true
                }

                val height = get(x, y)?.height ?: return false

                val visibleLeft = !trees.filter { it.x < x && it.y == y }.any { it.height >= height }
                val visibleRight = !trees.filter { it.x > x && it.y == y }.any { it.height >= height }
                val visibleUp = !trees.filter { it.x == x && it.y < y }.any { it.height >= height }
                val visibleDown = !trees.filter { it.x == x && it.y > y }.any { it.height >= height }

                return visibleLeft || visibleRight || visibleUp || visibleDown
            }

            fun isTreeVisible(index: Int): Boolean {
                val x = index % width
                val y = index / width
                return isTreeVisible(x, y)
            }

            fun calculateScenicScore(x: Int, y: Int): Int {
                // Tree is on edge
                if (x == 0 || y == 0 || x % (width - 1) == 0 || y % (length - 1) == 0) {
                    return 0
                }

                val height = get(x, y)?.height ?: return 0

                val treesLeft = trees.filter { it.x < x && it.y == y }.reversed()
                val treesRight = trees.filter { it.x > x && it.y == y }
                val treesUp = trees.filter { it.x == x && it.y < y }.reversed()
                val treesDown = trees.filter { it.x == x && it.y > y }

                val visibleLeft = treesLeft
                val visibleRight = !trees.filter { it.x > x && it.y == y }.any { it.height >= height }
                val visibleUp = !trees.filter { it.x == x && it.y < y }.any { it.height >= height }
                val visibleDown = !trees.filter { it.x == x && it.y > y }.any { it.height >= height }

                return visibleLeft * visibleRight * visibleUp * visibleDown
            }

            fun calculateScenicScore(index: Int): Int {
                val x = index % width
                val y = index / width
                return calculateScenicScore(x, y)
            }

            operator fun get(x: Int, y: Int): Tree? {
                return trees.getOrNull(y * width + x)
            }
        }

        fun part1(input: List<String>): Int {
            val treesList = input.map { line -> line.map { Tree(it.digitToInt()) } }.flatten()
            val forest = Forest(input.first().length, treesList.toMutableList())
            println("W: ${forest.width}, L: ${forest.length}")

            var visibleTreesCount = 0

            for (i in forest.indices) {
                if (forest.isTreeVisible(i)) visibleTreesCount++
            }

            return visibleTreesCount
        }

        fun part2(input: List<String>): Int {
            val treesList = input.map { line -> line.map { Tree(it.digitToInt()) } }.flatten()
            val forest = Forest(input.first().length, treesList.toMutableList())
            println("W: ${forest.width}, L: ${forest.length}")

            var maxScore = 0

            for (i in forest.indices) {
                val score = forest.calculateScenicScore(i)
                if (score > maxScore) {
                    val x = i % input.first().length
                    val y = i / input.first().length
                    println("Tree at ($x; $y) has score of $score")
                    maxScore = score
                }
            }

            return maxScore
        }

    }
}