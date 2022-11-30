import java.io.File

class IO {
    companion object {

        fun getInputText(day: Int): String {
            val dayString = if (day < 10) "0$day" else day.toString()
            return File("./inputs/day$dayString.txt").readText()
        }

        fun getInputLines(day: Int): List<String> {
            val dayString = if (day < 10) "0$day" else day.toString()
            return File("./inputs/day$dayString.txt").readLines()
        }

    }
}