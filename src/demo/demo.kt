package demo

import java.util.*

fun main() {
    val num = 10
    var total=0
//    calculator(10, total)
    val s: String?
    s=null // s=null
    val len1 = s?.length
    println(len1)

    // elvis
    val len2 = s?.length ?:0 // if left is null , then right
    println(len2)

//    val len3 = s!! // NPE throw


}
