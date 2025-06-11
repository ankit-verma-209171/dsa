package tuf.arrays.easy

/**
 * Move Zeros to Right while maintaining the order of the non-negative numbers
 *
 * Link: https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/
 */

private fun main() {
    val nums = intArrayOf(1, 0, 2, 3, 0, 4, 0, 1)
    moveZerosToEnd(nums = nums)
    println(nums.contentToString())
}

private fun moveZerosToEnd(nums: IntArray) {
    var i = 0
    var j = 0
    while (j < nums.size) {
        if (nums[j] == 0) ++j // skips 0
        else nums[i++] = nums[j++]
    }
    while (i < nums.size) {
        nums[i++] = 0
    }
}