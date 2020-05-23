package example

interface Production<out T> {
    fun produce(): T
}
interface Consumer<in T> {
    fun consume(item: T)
}
interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}

open class Food
open class FastFood: Food()
class Burger: FastFood()

// production
class FoodStore: Production<Food> {
    override fun produce(): Food {
        println("produce food")
        return Food()
    }
}

class FastFoodStore: Production<FastFood> {
    override fun produce(): FastFood {
        println("produce fast food")
        return FastFood()
    }
}

class BurgerStore: Production<Burger> {
    override fun produce(): Burger {
        println("produce burger")
        return Burger()
    }
}

val production1: Production<Food> = FoodStore()
val production2: Production<Food> = FastFoodStore()
val production3: Production<Food> = BurgerStore()
fun main() {
    production1.produce()
    production2.produce()
    production3.produce()

    consumer1.consume(Burger())
    consumer2.consume(Burger())
    consumer3.consume(Burger())
}

// consumer
class Everybody: Consumer<Food> {
    override fun consume(item: Food) {
        println("eat food")
    }
}
class ModernPeople: Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("eat fast food")
    }
}
class American: Consumer<Burger> {
    override fun consume(item: Burger) {
        println("eat burger")
    }
}
val consumer1: Consumer<Burger> = Everybody()
val consumer2: Consumer<Burger> = ModernPeople()
val consumer3: Consumer<Burger> = American()
