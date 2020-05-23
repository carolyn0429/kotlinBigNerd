package chapter12

import java.io.File
import java.lang.StringBuilder

const val TAVERN_NAME = "Taernyl's Folly"
const val LIST_WIDTH = 45
var playerGold = 10
var playerSilver = 10
// listOf is read-only
//val patronList = listOf("Eli", "Mordoc", "Sophie")
// change listOF to mutableList
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

val menuList = File("src/chapter10/tavern-menu-item.txt")
    .readText()
    .split("\n")
fun main() {

    // print all list elements
    println(patronList)

    // access list elements
    println(patronList.first())
    println(patronList.last())

    // access non-existent index, 1st element is index, 2nd element is lambda generate a default value
    // getOrElse is safe index access
    println(patronList.getOrElse(4){
        "Unknown index"
    })

    // bad practice, unless you handle null
    println(patronList.getOrNull(4))

    // after using mutableList and update elements
    patronList.remove("Eli")
    patronList.add(0,"Angela")
    println(patronList)

    // use Iteration over Collections
    // using for loop, simple and readable, easily control over how you iterate
//    for(patron in patronList) {
//        println(patron)
//    }

    // functional style, using forEach, it passes each element to anonymous function
    patronList.forEach { patron-> println(patron) }

    // ** kotlin for loop and forEach handle indexing behind the scenes
    patronList.forEachIndexed { index, patron ->
        println("Good evening, " +
            "$patron - you are #${index+1} in line.")
        placeOrder(
            patron,
            menuList.shuffled().first()
        )
    }
//    menuList.forEachIndexed { index, data -> println("$index: $data") }

    // Iterable category: List, Set, Map, IntRange
    // iterable supports iteration

}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"

    println(message)
    performPurchase(price.toDouble())
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: Ah delicious $name!"
    } else {
        "$patronName says: Thanks for the $name"
    }
    println(toDragonSpeak(phrase))

    formattingMenu(menuList)
}

fun formattingMenu(menuList: List<String>) {
    var maxLen = Integer.MIN_VALUE
    for(menu in menuList){
        if (menu.length>maxLen) maxLen = menu.length
    }
}

fun performPurchase(price:Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver /100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    println("Remaining balance:${"%.2f".format(remainingBalance)}")
}

private fun displayBalance() {
    println("Player's purse balance: Gold : $playerGold, Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")){
    when(it.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}
private fun formattedDots(maxLen:Int){
    val result = StringBuilder()
//    repeat()
}
// ** destructuring - declare and assign multiple variables in a single expression