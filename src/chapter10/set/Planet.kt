package chapter10.set

// ** set - not ordered, no duplicate
val planets = setOf("Mercury", "Venus", "Earth", "Earth")
fun main() {
    println(planets)
    println(planets.contains("Earth"))
    println(planets.contains("Pluto"))

    // no index concept for set
    planets.elementAt(2)

    // distinct = toSet->toList (drop duplicate and convert to index-based collection

}