package arrays.medium

/**
 * Stock Buy And Sell
 *
 * Link: https://takeuforward.org/data-structure/stock-buy-and-sell/
 */

private fun main() {
    val prices = intArrayOf(1, 2)
    val profit = findProfit(prices = prices)
    println(profit)
}

private fun findProfit(prices: IntArray): Int {
    var profit = 0
    var buyingPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < buyingPrice) buyingPrice = price
        else if (price - buyingPrice > profit) profit = price - buyingPrice
    }
    return profit
}