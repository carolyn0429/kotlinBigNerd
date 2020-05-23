
fun main(args: Array<String>) {
    val numLetters = "Mississippi".count { letter->letter == 's'}
    println(numLetters)

    fun runSimulation(playerName: String, greetingFun: (String, Int) -> String) {
        val numBuildings = (1..3).shuffled().last()
        println(greetingFun(playerName, numBuildings))
    }
//    val greetingFun = {
//        playerName:String, numOfBuildings:Int ->
//        "Welcome to SimVillage, $playerName has $numOfBuildings buildings! (copyright) 2020"
//    }
    runSimulation("Carol"){
            playerName:String, numOfBuildings:Int ->
        "Welcome to SimVillage, $playerName has $numOfBuildings buildings! (copyright) 2020"
    }
}
