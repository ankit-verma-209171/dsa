package tuf.binarysearch.array1d

/**
 * Binary Search
 *
 * Link: https://takeuforward.org/data-structure/binary-search-explained/
 */

private fun main() {
    val nums = intArrayOf(3, 4, 6, 7, 9, 12, 16, 17)
    val target = 6
    val index = binarySearch(nums = nums, low = 0, high = nums.size - 1, target = target)
    println(index)
}

private fun binarySearch(nums: IntArray, low: Int, high: Int, target: Int): Int? {
    var i = low
    var j = high
    while (i <= j) {
        val mid = i + (j - i) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> j = mid - 1
            else -> i = mid + 1
        }
    }
    return null
}
