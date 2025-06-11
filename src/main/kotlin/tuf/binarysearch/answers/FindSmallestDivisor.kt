package tuf.binarysearch.answers

/**
 * Find the Smallest Divisor Given a Threshold
 *
 * Link: https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5)
    val limit = 8
    val smallestDivisor = findSmallestDivisor(nums = nums, limit = limit)
    println("smallestDivisor: $smallestDivisor")
}

private fun findSmallestDivisor(nums: IntArray, limit: Int): Int {
    var low = 1
    var high = nums.max()
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (canDivideAndWithinThreshold(
                nums = nums,
                limit = limit,
                divisor = mid
            )
        ) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low
}

private fun canDivideAndWithinThreshold(
    nums: IntArray,
    limit: Int,
    divisor: Int
): Boolean {
    return nums
        .fold(0) { acc, num ->
            acc + (num + divisor - 1) / divisor
        } <= limit
}
