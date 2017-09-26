import scala.io.StdIn._
import scala.runtime.ScalaRunTime._

trait BoardGame {
  def readBoard(it: Iterator[String]): Array[Array[Char]]
}

class Sudoku extends BoardGame {
  override def readBoard(it: Iterator[String]): Array[Array[Char]] = {
    it.toArray.map(x => x.toCharArray.filter(_ != ' '))
  }
}

object SudokuGame extends App {
  val it = Iterator.continually(readLine()).takeWhile(_ != null)
  val sdku = new Sudoku
  println(stringOf(sdku.readBoard(it)))
}
