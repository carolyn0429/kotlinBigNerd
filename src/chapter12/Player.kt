package chapter12

class Player(s: String) {
    var name = "madrigal"
    // field = backing field is only accessible within getter or setter
        // backing field is not modified.
    get() = field.capitalize()

//     setter modifies backing field
//         exposing set() publicly is dangerous because everyone can modify class properties
//         adding private keyword so that setter only be modified within Player class
    private set(value){
        field = value.trim() // only when field's visibility is var not val(read-only)
    }

    var healthPoints = 100
    val isBlessed = true
    private val isImmortal = false

    override fun toString(): String {
        return javaClass.toString()
    }

    fun auraColor() : String {
        val auraVisible = isBlessed && healthPoints>50 ||isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }


    fun formatHealthStatus() =
        when(healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            in 15..74-> "looks pretty hurt."
            else -> "is in awful condition!"
        }


    // no private modifier
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
}