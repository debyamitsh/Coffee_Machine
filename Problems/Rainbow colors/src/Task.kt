import java.util.Scanner
    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)
        println(Rainbow.isName(input.next()))
    }
    
    enum class Rainbow(val color: String) {
        RED("Red"),
        ORANGE("Orange"),
        YELLOW("Yellow"),
        GREEN("Green"),
        BLUE("Blue"),
        INDIGO("Indigo"),
        VIOLET("Violet");

        companion object {
            fun isName(color: String) = color in values().map { it.color.toLowerCase() }
        }
    }
