package questions.easy

fun main() {
    val words = arrayOf("gin", "zen", "gig", "msg")
    println(uniqueMorseRepresentations(words))
}

// Time complexity: O(mn), being m the amount of words and n the largest word
// Space complexity: O(n), being n the amount of words
fun uniqueMorseRepresentations(words: Array<String>): Int {
    val unique = hashSetOf<String>()
    for (word in words) {
        val sb = StringBuilder()
        for (c in word) {
            sb.append(getMorseCode(c))
        }
        unique.add(sb.toString())
    }
    return unique.size
}

private fun getMorseCode(c: Char): String {
    val morseMapping = arrayOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    )
    return morseMapping[getIndex(c)]
}

private fun getIndex(c: Char) = c.minus('a')

