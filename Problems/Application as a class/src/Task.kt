class Application(val name: String) {

    fun run(args: Array<String>) {
        println(name)
        for (i in args) {
            println(i)
        }
    }
}