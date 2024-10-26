package arrays.medium

/**
 * Sort an array of 0s, 1s and 2s
 *
 * Link: https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
 */

private fun main() {
    val nums = intArrayOf(2, 0, 1)
    sortColors(nums)
    println(nums.contentToString())
}

/**
 * Sorting 3 numbers using Dutch Flag algorithm
 *
 * 0...low-1      => 0
 * low...mid-1    => 1
 * high+1...n-1   => 2
 */
private fun sortColors(nums: IntArray) {
    var low = 0
    var mid = 0
    var high = nums.lastIndex

    while (mid <= high) {
        when (nums[mid]) {
            0 -> {
                swap(nums, low, mid)
                ++low
                ++mid
            }

            1 -> {
                ++mid
            }

            2 -> {
                swap(nums, mid, high)
                --high
            }
        }
    }
}

private fun swap(nums: IntArray, l: Int, r: Int) {
    val temp = nums[l]
    nums[l] = nums[r]
    nums[r] = temp
}