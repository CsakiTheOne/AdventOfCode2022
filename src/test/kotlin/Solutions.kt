import days.*
import kotlin.test.Test

class Solutions {
    @Test
    fun day01test() {
        val ans = Day01.part1(IO.getInputLines(1))
        answer(ans)
        assert(ans == 71023)
    }

    @Test
    fun day01test2() {
        val ans = Day01.part2(IO.getInputLines(1))
        answer(ans)
        assert(ans == 206289)
    }

    @Test
    fun day02test() {
        val ans = Day02.part1(IO.getInputLines(2))
        answer(ans)
        assert(ans == 12679)
    }

    @Test
    fun day02test2() {
        val ans = Day02.part2(IO.getInputLines(2))
        answer(ans)
        assert(ans == 14470)
    }

    @Test
    fun day03test() {
        val ans = Day03.part1(IO.getInputLines(3))
        answer(ans)
        assert (ans == 7674)
    }

    @Test
    fun day03test2() {
        val ans = Day03.part2(IO.getInputLines(3))
        answer(ans)
        assert(ans == 2805)
    }

    @Test
    fun day04test() {
        val ans = Day04.part1(IO.getInputLines(4))
        answer(ans)
        assert(ans == 496)
    }

    @Test
    fun day04test2() {
        val ans = Day04.part2(IO.getInputLines(4))
        answer(ans)
        assert(ans == 847)
    }

    @Test
    fun day05test() {
        val ans = Day05.part1(IO.getInputText(5))
        answer(ans)
        assert(ans == "QPJPLMNNR")
    }

    @Test
    fun day05test2() {
        val ans = Day05.part2(IO.getInputText(5))
        answer(ans)
        assert(ans == "BQDNWJPVJ")
    }
}