package questions.easy

fun main() {
    val paths = listOf(
        listOf("London", "New York"),
        listOf("New York", "Lima"),
        listOf("Lima", "Sao Paulo")
    )
    println(destCity(paths))
}

// Time complexity: O(n), being n the number of paths
// Space complexity: O(n), being n the number of paths
fun destCity(paths: List<List<String>>): String {
    val origins = hashSetOf<String>()
    for(path in paths) {
        origins.add(path[0])
    }
    for(path in paths) {
        val destination = path[1]
        if(!origins.contains(destination)) return destination
    }
    return "-"
}
