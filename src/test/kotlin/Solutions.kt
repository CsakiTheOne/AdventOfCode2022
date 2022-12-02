import days.*
import kotlin.test.Test

class Solutions {
    @Test
    fun day00test() {
        assert(day00(IO.getInputText(0)))
    }

    @Test
    fun day01test() {
        val ans = day01(IO.getInputLines(1))
        println(ans)
        assert(ans == 71023)
    }

    @Test
    fun day01p2test() {
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
    fun day02p2test() {
        val ans = day02p2(IO.getInputLines(2))
        println(ans)
        assert(ans == 14470)
    }
}