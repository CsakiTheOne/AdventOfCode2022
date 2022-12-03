import days.*
import kotlin.test.Test

class Solutions {
    @Test
    fun day01test() {
        val ans = day01(IO.getInputLines(1))
        println(ans)
        assert(ans == 71023)
    }

    @Test
    fun day01test2() {
        val ans = day01p2(IO.getInputLines(1))
        println(ans)
        assert(ans == 206289)
    }

    @Test
    fun day02test() {
        val ans = day02(IO.getInputLines(2))
        println(ans)
        assert(ans == 12679)
    }

    @Test
    fun day02test2() {
        val ans = day02p2(IO.getInputLines(2))
        println(ans)
        assert(ans == 14470)
    }

    @Test
    fun day03test() {
        val ans = day03(IO.getInputLines(3))
        println(ans)
    }

    @Test
    fun day03test2() {

    }
}