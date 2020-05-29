import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow.valueOf("Red"))
}

enum class Rainbow(val color: String, val rgb: String) {
    RED("red", "#FF0000"),
    ORANGE("orange", "#FF7F00"),
    YELLOW("yellow", "#FFFF00"),
    GREEN("green", "#00FF00"),
    BLUE("blue", "#0000FF"),
    INDIGO("indigo", "#4B0082"),
    VIOLET("violet", "#8B00FF"),
    NULL("", "");

    companion object {
        fun findByRgb(color: String): Rainbow {
            for (enum in Rainbow.values()) {
                if (color == enum.color) return enum
            }
            return NULL
        }
    }
}