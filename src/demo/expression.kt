package demo

//// Traditional usage
//
//var max = a
//if (a < b) max = b
//
//// With else
//var max: Int
//if (a > b) {
//    max = a
//} else {
//    max = b
//}

// As expression
fun main() {
    var a=1
    var b=2
   // val max = if (a > b) a else b
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
    println(max)
}




