package arrays.medium

/**
 * Spiral Traversal
 *
 * Link: https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
 */

private fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16),
    )
    val traversal = spiralTraverse(matrix)
    println(traversal)
}

private fun spiralTraverse(matrix: Array<IntArray>): List<Int> {
    var left = 0
    var right = matrix[0].size - 1
    var top = 0
    var bottom = matrix.size - 1

    var i = 0
    var j = 0

    val result = mutableListOf<Int>()

    fun isNotValid(): Boolean = left > right || top > bottom

    while (true) {

        if (isNotValid()) break

        // Traverse right
        while (j <= right) {
            result += matrix[i][j]
            ++j
        }
        --j

        // Traverse bottom
        ++i
        if (i > bottom) break
        while (i <= bottom) {
            result += matrix[i][j]
            ++i
        }
        --i

        // Traverse left
        --j
        if (j < left) break
        while (j >= left) {
            result += matrix[i][j]
            --j
        }
        ++j

        // Traverse top
        --i
        if (i == top) break
        while (i > top) {
            result += matrix[i][j]
            --i
        }
        ++i
        ++j

        // Update the traverse path
        ++left
        ++top
        --right
        --bottom
    }

    return result
}