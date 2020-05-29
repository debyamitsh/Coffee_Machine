data class Player(val id: Int, val name: String, val hp: Int = 100) {
    var mat = id + 1
    companion object {
        fun create(name: String) :  Player {
            return Player("")
        }
    }
}