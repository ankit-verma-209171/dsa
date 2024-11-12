package arrays.hard

/**
 * Count inversions in an array
 *
 * Link: https://takeuforward.org/data-structure/count-inversions-in-an-array/
 */

private fun main() {
    val nums = intArrayOf(5, 3, 2, 1, 4)
    val inversions = mergeSort(nums = nums)
    println(nums.contentToString())
    println(inversions)
}

private fun mergeSort(nums: IntArray, left: Int = 0, right: Int = nums.size - 1): Int {
    var inversions = 0
    if (left >= right) return inversions
    val mid = left + (right - left) / 2
    inversions += mergeSort(nums = nums, left = left, right = mid)
    inversions += mergeSort(nums = nums, left = mid + 1, right = right)
    inversions += merge(nums = nums, left = left, mid = mid, right = right)
    return inversions
}

private fun merge(nums: IntArray, left: Int, mid: Int, right: Int): Int {
    var inversions = 0
    var i = left
    var j = mid + 1
    var k = 0
    var res = IntArray(right - left + 1) { 0 }
    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            res[k++] = nums[i++]
        } else {
            inversions += (mid - i + 1)
            res[k++] = nums[j++]
        }
    }
    while (i <= mid) {
        res[k++] = nums[i++]
    }
    while (j <= right) {
        res[k++] = nums[j++]
    }

    for ((idx, value) in res.withIndex()) {
        nums[left + idx] = value
    }

    return inversions
}