package tuf.sorts

/**
 * Merge Sort
 *
 * Link: https://takeuforward.org/data-structure/merge-sort-algorithm/
 *
 * Algorithm:
 * 1. Keep dividing the array in equal parts until single element remains
 * 2. Compare the 2 divided segments and merge them by sorting them properly
 * 3. Repeat step 2 until single segment remains
 */

private fun main() {
    val nums = intArrayOf(3, 2, 8, 5, 1, 4, 23)
    mergeSort(nums)
    println(nums.contentToString())
}

private fun mergeSort(array: IntArray, low: Int = 0, high: Int = array.lastIndex) {
    if (low >= high) return
    val mid = (low + high) / 2
    mergeSort(array = array, low = low, high = mid)
    mergeSort(array = array, low = mid + 1, high = high)
    merge(array = array, low = low, mid = mid, high = high)
}

private fun merge(array: IntArray, low: Int, mid: Int, high: Int) {
    val mergedArray = IntArray(high - low + 1) { 0 }
    var i = low
    var j = mid + 1
    var k = 0

    while (i <= mid && j <= high) {
        if (array[i] < array[j]) {
            mergedArray[k++] = array[i++]
        } else {
            mergedArray[k++] = array[j++]
        }
    }

    while (i <= mid) {
        mergedArray[k++] = array[i++]
    }

    while (j <= high) {
        mergedArray[k++] = array[j++]
    }

    for ((idx, num) in mergedArray.withIndex()) {
        array[idx + low] = num
    }
}
