fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer() {
    var time: Int = 0
    constructor(time: Int) : this() {
        this.time = time
    }
    time = time
}