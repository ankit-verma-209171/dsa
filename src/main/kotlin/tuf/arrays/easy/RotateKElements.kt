package tuf.arrays.easy

/**
 * Rotate the array by K elements
 *
 * Link: https://takeuforward.org/data-structure/rotate-array-by-k-elements/
 *
 * Algorithm: Rotation using "Reversal Algorithm"
 */

private fun main() {
    val nums = intArrayOf(-1, -100, 3, 99)
    rotateKElementsLeft(nums = nums, k = 3)
    println(nums.contentToString())
}

private fun rotateKElementsLeft(nums: IntArray, k: Int) {
    if (k == 0) return
    if (nums.size == 1) return
    val n = nums.size
    val boundK = k % n
    // Reverse first k elements
    reverseElements(nums = nums, low = 0, high = boundK - 1)
    // Reverse last k elements
    reverseElements(nums = nums, low = boundK, high = n - 1)
    // Reverse whole array
    reverseElements(nums = nums, low = 0, high = n - 1)
}

private fun rotateKElementsRight(nums: IntArray, k: Int) {
    if (k == 0) return
    if (nums.size == 1) return
    val n = nums.size
    val boundK = k % n
    // Reverse first n - k elements
    reverseElements(nums = nums, low = 0, high = n - boundK - 1)
    // Reverse last n - k elements
    reverseElements(nums = nums, low = n - boundK, high = n - 1)
    // Reverse whole array
    reverseElements(nums = nums, low = 0, high = n - 1)
}

private fun reverseElements(nums: IntArray, low: Int = 0, high: Int = nums.lastIndex) {
    var i = low
    var j = high
    while (i < j) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
        ++i
        --j
    }
}
