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
}