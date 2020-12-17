package questions.medium

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    permute(nums).forEach { permutation ->
        permutation.forEach { num -> print("$num ") }
        println()
    }
}

// Time complexity: O(n!), being n the amount of numbers
// Space complexity: O(n!), being n the amount of numbers
fun permute(nums: IntArray): List<List<Int>> {
    val permutations = mutableListOf<List<Int>>()
    if (nums.isNotEmpty()) {
        val subset = mutableListOf<Int>()
        val visited = hashSetOf<Int>()
        dfs(nums, permutations, subset, visited)
    }
    println(permutations.size)
    return permutations
}

private fun dfs(
    nums: IntArray,
    permutations: MutableList<List<Int>>,
    subset: MutableList<Int>,
    visited: HashSet<Int>,
) {
    if (subset.size == nums.size) {
        permutations.add(listOf(*subset.toTypedArray()))
        return
    }

    for (num in nums) {
        if (!visited.add(num)) continue
        subset.add(num)
        dfs(nums, permutations, subset, visited)
        visited.remove(num)
        subset.removeLast()
    }
}


