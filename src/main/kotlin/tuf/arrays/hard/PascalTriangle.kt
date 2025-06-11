package tuf.arrays.hard

/**
 * Program to generate Pascal's Triangle
 *
 * Link: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 */

private fun main() {
    val n = 5
    val pascalTriangle = generatePascalTriangle(n = n)
    println(pascalTriangle)
}

private fun generatePascalTriangle(n: Int): List<List<Int>> {
    if (n <= 0) return emptyList()
    val pascalTriangle = mutableListOf<List<Int>>()
    pascalTriangle += listOf(1)
    for (i in 1..< n) {
        val row = mutableListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                row += 1
                continue
            }
            row += pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]
        }
        pascalTriangle += row
    }
    return pascalTriangle
}
