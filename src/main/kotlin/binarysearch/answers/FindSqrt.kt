package binarysearch.answers

import kotlin.math.sqrt

/**
 * Finding Sqrt of a number using Binary Search
 *
 * Link: https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/
 */

private fun main() {
    repeat(100) {
        val match = (sqrt(it.toFloat()).toInt()) == findSqrt(it)
        println("Number: $it Expected: ${sqrt(it.toFloat()).toInt()}, Actual: ${findSqrt(it)} Verdict: $match")
    }
}

private fun findSqrt(num: Int): Int {
    if (num == 0 || num == 1) return num
    var low = 1
    var high = num
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (mid <= num / mid) low = mid + 1
        else high = mid - 1
    }
    return high
}
