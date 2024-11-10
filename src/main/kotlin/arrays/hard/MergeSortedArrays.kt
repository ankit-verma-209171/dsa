package arrays.hard

/**
 * Merge two Sorted Arrays Without Extra Space
 *
 * Link: https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 */

private fun main() {
    val arr1 = intArrayOf(1, 3, 5, 7)
    val arr2 = intArrayOf(0, 2, 6, 8, 9)
    mergeArrays(arr1 = arr1, arr2 = arr2)
    println(arr1.contentToString())
    println(arr2.contentToString())
}

private fun mergeArrays(arr1: IntArray, arr2: IntArray) {
    var i = 0
    while (i < arr1.size) {
        if (arr1[i] > arr2[0]) {
            val temp = arr1[i]
            arr1[i] = arr2[0]
            arr2[0] = temp
            var j = 0
            while (j + 1 < arr2.size && arr2[j] > arr2[j + 1]) {
                val temp = arr2[j]
                arr2[j] = arr2[j + 1]
                arr2[j + 1] = temp
                ++j
            }
        }
        ++i
    }
}
