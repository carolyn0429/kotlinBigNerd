package demo

import java.util.*

fun main() {
    // val vs var
    val dateOfBirth = "29th March, 1709"
    dateOfBirth = "25th December, 1600" // cannot be changed

    var car = "Toyota Matrix"
    car = "Mercedes-Maybach" // can be changed

    val s: String?
    s=null // s=null
    val len1 = s?.length
    println(len1)

    // elvis
    val len2 = s?.length ?:0 // if left is null , then right
    println(len2)

//    val len3 = s!! // NPE throw

    println(foo())
}

fun foo() : String  {
    return "42"
}
//fun foo() = "42"