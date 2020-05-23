package chatper9

fun main() {
 fun formatGreeting(vipGuest: String?):String {
     return vipGuest?.let{
         "Welcome, $it. Please go straight back your table is ready." ?: "Welcome to the tavern. You"
     }.toString()
 }
}
