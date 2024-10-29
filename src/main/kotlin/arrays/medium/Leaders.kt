package arrays.medium

/**
 * Leaders in an Array
 *
 * Link: https://takeuforward.org/data-structure/leaders-in-an-array/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 2, 1)
    val leaders = findLeaders(nums = nums)
    println(leaders.contentToString())
}

/**
 * Leaders are greater than the numbers following them,
 * so to find leader we should keep track of the biggest number that is to right of them
 */
private fun findLeaders(nums: IntArray): IntArray {
    var biggest = -1
    var i = nums.lastIndex
    val leaders = mutableListOf<Int>()
    while (i >= 0) {
        if (nums[i] > biggest) {
            leaders += nums[i]
            biggest = nums[i]
        }
        --i
    }
    return leaders.toIntArray()
}