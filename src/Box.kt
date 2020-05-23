import kotlin.test.assertTrue

class Box<T>(val item: T)
fun <T:Number> combineToString(num1:T, num2:T) = "$num1$num2"

// out
class ParameterizedClassProducer<out T>(private val value: T){
    fun get(): T {
        return value
    }
}

// in
class ParameterizedClassConsumer<in T>{
    fun toString(value:T):String{
        return value.toString()
    }

}
fun main() {
    // class/function/interface generics
    println(Box(listOf("Kotlin", "Java", "Javascript", "Python", "Scala")).item)
    val nums = arrayOf<Number>(1.02, 2)
    println(combineToString(nums[0], nums[1]))

    // out
    val parameterizedClassProducer = ParameterizedClassProducer("string")
    val ref: ParameterizedClassProducer<Any> = parameterizedClassProducer
    assertTrue(ref is ParameterizedClassProducer<Any>)

    // in
    val parameterizedClassConsumer = ParameterizedClassConsumer<Number>()
    val ref1: ParameterizedClassConsumer<Double> = parameterizedClassConsumer
    assertTrue(ref1 is ParameterizedClassConsumer<Double>)



}