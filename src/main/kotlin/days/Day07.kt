package days

import words

class Day07 {
    companion object {

        private val directoryData = mutableListOf<Directory>()
        private var workingDirectory = "/"

        data class Directory(
            val path: String,
            val subdirectories: MutableList<String> = mutableListOf(),
            var filesSize: Int = 0,
        ) {
            fun getFullSize(): Int {
                val subdirectoriesDirectory = directoryData.filter { subdirectories.contains(it.path) }
                return filesSize + subdirectoriesDirectory.sumOf { it.getFullSize() }
            }
        }

        fun part1(input: List<String>): Int {
            fun executeCommand(line: String) {
                if (line.first() != '$') throw Exception("\"$line\" is not a command!")

                val params = line.words()

                if (params[1] != "cd") return

                when (params[2]) {
                    ".." -> workingDirectory = workingDirectory.substringBeforeLast("/")
                    "/" -> workingDirectory = "/"
                    else -> workingDirectory += "/${params[2]}"
                }
                workingDirectory = workingDirectory.replace("//", "/")
            }

            fun processFile(line: String) {
                if (!directoryData.any { it.path == workingDirectory }) {
                    directoryData.add(Directory(workingDirectory))
                }
                if (line.startsWith("dir")) {
                    val subdirPath = "$workingDirectory${if (workingDirectory.last() == '/') "" else "/"}${line.substringAfter("dir ")}"
                    directoryData.first { it.path == workingDirectory }.subdirectories.add(subdirPath)
                }
                else {
                    directoryData.first { it.path == workingDirectory }.filesSize += line.substringBefore(" ").toInt()
                }
            }

            input.forEach { line ->
                if (line.first() == '$') executeCommand(line)
                else processFile(line)
            }

            return directoryData.filter { it.getFullSize() <= 100000 }.sumOf { it.getFullSize() }
        }

        fun part2(input: List<String>): Int {
            val storageSize = 70_000_000
            val spaceRequired = 30_000_000

            part1(input)

            val spaceUsed = directoryData.first().getFullSize()
            val freeSpace = storageSize - spaceUsed

            return directoryData.sortedBy { it.getFullSize() }.first { it.getFullSize() > spaceRequired - freeSpace }.getFullSize()
        }

    }
}