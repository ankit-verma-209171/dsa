package binarysearch.array1d

/**
 * Minimum in Rotated Sorted Array
 *
 * Link: https://takeuforward.org/data-structure/minimum-in-rotated-sorted-array/
 */

private fun main() {
    val nums = intArrayOf(11,13,15,17)
    val minValue = findMinimum(nums = nums)
    println("Nums: $nums $minValue")
}

private fun findMinimum(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var low = 0
    var high = nums.lastIndex
    if (nums[0] < nums[high]) return nums[low]
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1]
        }
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid]
        }
        if (nums[mid] > nums[0]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return -10000
}

/**
 *         if(nums.size == 1){
 *             return nums[0]
 *         }
 *
 *         var left = 0
 *         var right = nums.size - 1
 *         if(nums[0] < nums[right]){
 *             return nums[0]
 *         }
 *
 *         while(left <= right){
 *             var pivot = (left + right) / 2
 *             if(nums[pivot] > nums[pivot + 1]){
 *                 return nums[pivot + 1]
 *             }
 *             if(nums[pivot - 1] > nums[pivot]){
 *                 return nums[pivot]
 *             }
 *             if(nums[pivot] > nums[0]){
 *                 left = pivot + 1
 *             }
 *             else{
 *                 right = pivot - 1
 *             }
 *         }
 *         return Int.MAX_VALUE
 */