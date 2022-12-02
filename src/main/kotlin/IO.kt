import java.io.File

class IO {
    companion object {

        fun getInputText(day: Int, filename: String = ""): String {
            val dayString = if (day < 10) "0$day" else day.toString()
            return File("./inputs/day$dayString$filename.txt").readText()
        }

        fun getInputLines(day: Int, filename: String = ""): List<String> {
            val dayString = if (day < 10) "0$day" else day.toString()
            return File("./inputs/day$dayString$filename.txt").readLines()
        }

    }
}