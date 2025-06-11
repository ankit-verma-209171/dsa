package tuf.arrays.medium

/**
 * Set Matrix Zero
 *
 * Link: https://takeuforward.org/data-structure/set-matrix-zero/
 */

private fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 2, 0),
        intArrayOf(3, 4, 5, 2),
        intArrayOf(1, 3, 1, 5),
    )
    setZeros(matrix = matrix)
    matrix.forEach { println(it.contentToString()) }
}

private fun setZeros(matrix: Array<IntArray>) {
    val n = matrix.size
    val m = matrix[0].size

    var isFirstColumnZero = false
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                if (j != 0) matrix[0][j] = 0
                else isFirstColumnZero = true
            }
        }
    }

    for (i in 1..<n) {
        for (j in 1..<m) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }

    if (matrix[0][0] == 0) {
        for (j in 0..<m) {
            matrix[0][j] = 0
        }
    }

    if (isFirstColumnZero) {
        for (i in 0..<n) {
            matrix[i][0] = 0
        }
    }
}
