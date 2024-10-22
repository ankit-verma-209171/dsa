package sorts

/**
 * QuickSort
 *
 * Link: https://takeuforward.org/data-structure/quick-sort-algorithm/
 *
 * Algorithm:
 * 1. Find random pivot
 * 2. Place the pivot value in proper position
 * 3. Swap items such that values-left <= pivot-value <= values-high
 * 4. Divide the segment and repeat from step 1
 */

private fun main() {
    val nums = intArrayOf(4, 6, 2, 5, 7, 9, 1, 3)
    quickSort(nums)
    println(nums.contentToString())
}

private fun quickSort(nums: IntArray, low: Int = 0, high: Int = nums.lastIndex) {
    // Base condition
    if (low >= high) return

    // Partitioning
    val pivot = nums[low]
    var i = low
    var j = high

    while (i < j) {
        while (i < high && nums[i] <= pivot) ++i
        while (j >= low && nums[j] > pivot) j--

        if (i < j) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }
    }
    val tmp = nums[low]
    nums[low] = nums[j]
    nums[j] = tmp

    // Divide & Conquer
    quickSort(nums, low, j-1)
    quickSort(nums, j+1, high)
}