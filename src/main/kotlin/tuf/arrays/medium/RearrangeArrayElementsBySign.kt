package tuf.arrays.medium

/**
 * Rearrange Array Elements by Sign
 *
 * Link: https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
 */

private fun main() {
    val nums = intArrayOf(-1, 1)
    sortBySigns(nums)
    println(nums.contentToString())
}

private fun sortBySigns(nums: IntArray) {
    val pos = nums.filter { it >= 0 }
    val neg = nums.filter { it < 0 }
    for (i in pos.indices) {
        nums[2 * i] = pos[i]
        nums[2 * i + 1] = neg[i]
    }
}
