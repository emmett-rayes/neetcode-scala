import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
 * to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
def valid_sudoku(board: Array[Array[Char]]): Boolean =
  val height = board.length
  val width = board(0).length
  val block = board.length / 3

  val rows = (for (i <- 0 to height) yield (i, mutable.HashSet[Char]())).toMap
  val columns = (for (j <- 0 to width) yield (j, mutable.HashSet[Char]())).toMap
  val blocks = (for (i <- 0 to block; j <- 0 to block) yield ((i, j), mutable.HashSet[Char]())).toMap

  boundary:
    for ((r, i) <- board.zipWithIndex) do
      for ((c, j) <- r.zipWithIndex) do
        if c != '.' then
          if rows(i).contains(c) then break(false) else rows(i).add(c)
          if columns(j).contains(c) then break(false) else columns(j).add(c)
          if blocks((i / block, j / block)).contains(c) then break(false) else
            blocks((i / block, j / block)).add(c)
    true
