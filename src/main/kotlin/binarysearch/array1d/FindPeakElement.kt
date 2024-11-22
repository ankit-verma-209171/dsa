package binarysearch.array1d

/**
 * Peak element in Array
 *
 * Link: https://takeuforward.org/data-structure/peak-element-in-array/
 */

private fun main() {
    val nums = intArrayOf(3, 4, 3, 2, 1)
    val peak = findPeak(nums = nums)
    println(peak)
}

private fun findPeak(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return 0
    if (nums[0] > nums[1]) return 0
    if (nums[n - 1] > nums[n - 2]) return n - 1
    var low = 0
    var high = n - 1
    while (low <= high) {
        val mid = (low + high) / 2
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
            return mid
        } else if (mid == n - 1 || nums[mid] < nums[mid + 1]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return -1
}