package binarysearch.answers

/**
 * Allocate Minimum Number of Pages
 *
 * Link: https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/
 */

private fun main() {
    val pages = intArrayOf(25, 46, 28, 49, 24)
    val students = 4
    val count = findMaximumPagesReadByAnyStudentGivenMinimumPossiblePages(
        pages = pages,
        students = students
    )
    println(count)
}

private fun findMaximumPagesReadByAnyStudentGivenMinimumPossiblePages(
    pages: IntArray,
    students: Int
): Int {

    if (pages.size < students) return -1
    if (pages.size == students) return pages.max()

    var low = pages.max()
    var high = pages.sum()

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (
            isAllocationPossible(
                pages = pages,
                students = students,
                maximumNumberOfPagesSingleStudentCanBeAllocated = mid
            )
        ) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low
}

private fun isAllocationPossible(
    pages: IntArray,
    students: Int,
    maximumNumberOfPagesSingleStudentCanBeAllocated: Int
): Boolean {
    var numberOfStudentsThatCanBeAllocatedBooks = 1
    var numberOfPagesCanBeAllocated = 0
    pages.forEach { page ->
        if (numberOfPagesCanBeAllocated + page <= maximumNumberOfPagesSingleStudentCanBeAllocated) {
            numberOfPagesCanBeAllocated += page
        } else {
            ++numberOfStudentsThatCanBeAllocatedBooks
            numberOfPagesCanBeAllocated = page
        }
    }
    return numberOfStudentsThatCanBeAllocatedBooks > students
}
