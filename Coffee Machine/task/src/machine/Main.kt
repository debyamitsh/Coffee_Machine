package machine

import java.util.Scanner

class CoffeeMachine {
    var water = 400
    var milk = 540
    var bean = 120
    var cup = 9
    var money = 550
    var state = State.EXIT
    var skip = false

    enum class Coffee(val water: Int, val milk: Int, val bean: Int, val money: Int) {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6)
    }

    enum class State(val dialog: String) {
        START("Write action (buy, fill, take, remaining, exit): "),
        BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "),
        FILL("Write how many ml of water do you want to add: "),
        FILL_MILK("Write how many ml of milk do you want to add: "),
        FILL_BEAN("Write how many grams of coffee beans do you want to add: "),
        FILL_CUP("Write how many disposable cups of coffee do you want to add: "),
        TAKE(""),
        REMAINING(""),
        EXIT("");

        companion object {
            fun getState(state: String): State {
                for (enum in values()) if (enum.toString() == state) return enum
                return START
            }
        }
    }

    fun start() {
        reset()
        run("START")
    }

    fun on(): Boolean {
        return state != State.EXIT
    }

    fun reset() {
        state = State.START
    }

    fun displayCoffee() {
        println("""
        The coffee machine has:
        $water of water
        $milk of milk
        $bean of coffee beans
        $cup of disposable cups
        $$money of money
    """.trimIndent())
    }
    fun checkNum(string: String): Boolean {
        return string.toIntOrNull() != null
    }
    fun getCoffee(coffee: Coffee) {
        when {
            cup <= 0 -> println("Sorry, not enough cups!")
            coffee.water > water -> println("Sorry, not enough water!")
            coffee.milk > milk -> println("Sorry, not enough milk!")
            coffee.bean > bean -> println("Sorry, not enough coffee beans!")
            else -> {
                water -= coffee.water
                milk -= coffee.milk
                bean -= coffee.bean
                cup--
                money += coffee.money
                println("I have enough resources, making you a coffee!")
            }
        }
    }

    fun run(string: String) {
        if (on()) {
            if (state == State.START) state = State.getState(string)
            when (state) {
                State.START -> {
                    print(state.dialog)
                    return
                }
                State.BUY -> {
                    when (string) {
                        "1" -> {
                            getCoffee(Coffee.ESPRESSO)
                            reset()
                        }
                        "2" -> {
                            getCoffee(Coffee.LATTE)
                            reset()
                        }
                        "3" -> {
                            getCoffee(Coffee.CAPPUCCINO)
                            reset()
                        }
                        "BACK" -> reset()
                    }
                }
                State.FILL -> {
                    if (checkNum(string)) {
                        water += string.toInt()
                        state = State.FILL_MILK
                        skip = true
                    }
                }
                State.FILL_MILK -> {
                    if (checkNum(string)) {
                        milk += string.toInt()
                        state = State.FILL_BEAN
                    }
                }
                State.FILL_BEAN -> {
                    if (checkNum(string)) {
                        bean += string.toInt()
                        state = State.FILL_CUP
                    }
                }
                State.FILL_CUP -> {
                    if (checkNum(string)) {
                        cup += string.toInt()
                        reset()
                        skip = false
                    }
                }
                State.TAKE -> {
                    println("I gave you $${money}")
                    money = 0
                    reset()
                }
                State.REMAINING -> {
                    displayCoffee()
                    reset()
                }
                State.EXIT -> 0
            }
            if (!skip) println("")
            print(state.dialog)
        }
    }
}
fun main() {
    val scanner = Scanner(System.`in`)
    val coffee = CoffeeMachine()
    coffee.start()
    while (coffee.on()) coffee.run(scanner.nextLine().toUpperCase())
}