import scala.io.StdIn._
import scala.runtime.ScalaRunTime._
import scala.collection.immutable.IndexedSeq

trait BoardGame {
  def readBoard(it: Iterator[String]): Array[Array[Char]]
}

object Sudoku extends BoardGame {
  val numSet = (1 until 10).map(x => x.toString.toCharArray).map(x => x(0))
  override def readBoard(it: Iterator[String]): Array[Array[Char]] = {
    it.toArray.map(x => x.toCharArray.filter(_ != ' '))
  }
}

class Sudoku(val brd: Array[Array[Char]]) {
  def isValid(): Boolean = {
    val cols = for {
      idx <- brd(0).indices
    } yield brd.map(c => c(idx))
    val hasNoReps = (nums: Seq[Array[Char]]) =>
      nums.map(inner => inner.toSet.toList == inner.toList).reduce(_ && _)
    val belongsToSet = (nums: Seq[Array[Char]] ) =>
      nums.map(c => c.toSet subsetOf Sudoku.numSet.toSet).reduce((x,y) => x && y)
    val hasValidNums = (nums: Seq[Array[Char]] ) => hasNoReps(nums) && belongsToSet(nums)
    val colsValid = hasValidNums(cols)
    val rowsValid = hasValidNums(brd)
    return colsValid && rowsValid
  }
}

object SudokuGame extends App {
  val it = Iterator.continually(readLine()).takeWhile(_ != null)
  val brd = Sudoku.readBoard(it)
  val sdku = new Sudoku(brd)
  println(sdku.isValid)
}
