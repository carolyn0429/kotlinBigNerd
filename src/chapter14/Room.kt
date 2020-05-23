package chapter14

import chapter12.Player

// adding open keyword to make Room class can be subclassed
open class Room(val name: String) {

    //1 to 10, protected val can be accessible in class and its subclass
    protected open val dangerLevel = 5
    fun description() = "Room: $name\n Danger level: $dangerLevel"
    open fun load() = "Nothing much to see here..."
    override fun toString(): String {
        return javaClass.toString()
    }
}

class TownSquare: Room("Town Square"){
    override fun load() = "the villages rally and cheer as you enter!\n${ringBell()}"
    override val dangerLevel = super.dangerLevel - 3
//    override val dangerLevel: Int
//        get() = super.dangerLevel - 3

    private var bellSound = "GWONG"
    private fun ringBell() =
        "The bell tower announces your arrival. $bellSound"
}

fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if(any is Player) {
        any.isBlessed
    } else {
        (any as Room).name == "Fount of Blessings"
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}
fun main() {

    printIsSourceOfBlessings(Player("Madrigal"))
    printIsSourceOfBlessings(Room("Fount of Blessings"))
}