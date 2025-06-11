package tuf.arrays.hard

/**
 * Find the repeating and missing numbers
 *
 * Link: https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 */

private fun main() {
    val nums = intArrayOf(3, 1, 2, 5, 3)
    val (missing, repeating) = findMissingAndRepeatingNumbers(nums = nums)
    println("Found missing number $missing and repeating number $repeating")
}

private fun findMissingAndRepeatingNumbers(nums: IntArray): IntArray {
    val n = nums.size
    var sumOfNumbers = 0
    var sumUptoN = 0
    var sumOfSquareOfNumbers = 0
    var sumOfSquaresUptoN = 0

    // Calculate the necessary sums
    for (i in 0..<n) {
        sumOfNumbers += nums[i]
        sumUptoN += i + 1
        sumOfSquareOfNumbers += nums[i] * nums[i]
        sumOfSquaresUptoN += (i + 1) * (i + 1)
    }

    // Calculate the differences
    val sumDifference = sumOfNumbers - sumUptoN
    val sumOfSquareDifference = sumOfSquareOfNumbers - sumOfSquaresUptoN

    // Calculate the missing and repeating numbers
    val remaining = ((sumOfSquareDifference / sumDifference) + sumDifference) / 2
    val missing = remaining - sumDifference

    // Return the result
    return intArrayOf(missing, remaining)
}
