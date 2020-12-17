package questions.easy

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))
}

// Time complexity: O(n), being n the amount of prices
// Space complexity: O(1), no extra space required
fun maxProfit(prices: IntArray): Int {
    var minPrice = Integer.MAX_VALUE
    var maxProfit = 0
    for (price in prices) {
        if (price < minPrice) minPrice = price
        else maxProfit = Math.max(maxProfit, price.minus(minPrice))
    }
    return maxProfit
}


