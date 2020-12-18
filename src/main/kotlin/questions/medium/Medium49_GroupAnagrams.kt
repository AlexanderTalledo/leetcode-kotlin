package questions.medium

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    groupAnagrams(strs).forEach { group ->
        group.forEach { anagram ->
            print("$anagram ")
        }
        println()
    }
}

// Time complexity: O(nklog(k)), being n the amount of strings and k the length of the longest string
// Space complexity: O(nk), being n the amount of strings and k the length of the longest string
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val groups = mutableListOf<List<String>>()
    val anagramsMap = mutableMapOf<String, MutableList<String>>()
    for (s in strs) {
        val key = generateAnagramKey(s)
        if (anagramsMap.containsKey(key)) anagramsMap[key]!!.add(s)
        else anagramsMap[key] = mutableListOf(s)
    }
    anagramsMap.values.forEach { group -> groups.add(group) }
    return groups
}

private fun generateAnagramKey(s: String): String {
    val letters = s.toCharArray()
    letters.sort()
    return String(letters)
}


