import java.util.*

enum class Rainbow(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern caribbean dollar"),
    Kiribati("Australian dollar");

    companion object {
        fun isInRainbow(country: String) {
            for (enum in Rainbow.values()) if (country == enum.currency) println(enum)
        }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(Rainbow.isInRainbow(input.next()))
}
