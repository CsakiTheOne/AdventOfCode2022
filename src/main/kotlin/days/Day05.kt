package days

import days.Day05.Companion.columns
import days.Day05.Companion.words
import java.util.Stack

class Day05 {
    companion object {

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

        fun part1(input: String): String {
            val crateText = input.substringBefore("\n\n")
            val procedure = input.substringAfter("\n\n").lines()

            // Create stacks
            val crateStacks = mutableListOf<Stack<Char>>()
            for (i in crateText.columns().indices) {
                if (i % 4 == 1) {
                    val stack = Stack<Char>()
                    crateText.columns()[i].reversed().forEach { c ->
                        if (c != ' ' && c != crateText.columns()[i].last()) {
                            stack.push(c)
                        }
                    }
                    crateStacks.add(stack)
                }
            }

            println(crateStacks)

            procedure.forEach { command ->
                // move X from Y to Z
                val words = command.words()
                val count = words[1].toInt()
                val cFrom = words[3].toInt() - 1
                val cTo = words[5].toInt() - 1

                repeat(count) {
                    crateStacks[cTo].push(crateStacks[cFrom].pop())
                }

                println(command)
                println(crateStacks)
            }

            return crateStacks.joinToString("") { it.peek().toString() }
        }

        fun part2(input: String): String {
            val crateText = input.substringBefore("\n\n")
            val procedure = input.substringAfter("\n\n").lines()

            // Create stacks
            val crateStacks = mutableListOf<Stack<Char>>()
            for (i in crateText.columns().indices) {
                if (i % 4 == 1) {
                    val stack = Stack<Char>()
                    crateText.columns()[i].reversed().forEach { c ->
                        if (c != ' ' && c != crateText.columns()[i].last()) {
                            stack.push(c)
                        }
                    }
                    crateStacks.add(stack)
                }
            }

            println(crateStacks)

            procedure.forEach { command ->
                // move X from Y to Z
                val words = command.words()
                val count = words[1].toInt()
                val cFrom = words[3].toInt() - 1
                val cTo = words[5].toInt() - 1

                val tempStack = Stack<Char>()
                repeat(count) {
                    tempStack.push(crateStacks[cFrom].pop())
                }
                repeat(count) {
                    crateStacks[cTo].push(tempStack.pop())
                }

                println(command)
                println(crateStacks)
            }

            return crateStacks.joinToString("") { it.peek().toString() }
        }

    }
}