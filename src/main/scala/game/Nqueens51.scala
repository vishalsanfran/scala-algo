package game

object Nqueens51 {
  def getRow(n: Int, idx: Int = -1): String= {
    (0 until n).map(x => if (x == idx) "Q" else ".").mkString("")
  }

  def getInitBoard(n: Int): Array[String] = {
    (0 until n).map(_ => getRow(n)).toArray
  }

  def solutions(n: Int): List[List[String]] = {
    val qLocs: Array[Int] = (0 until n).map(_ => -1).toArray
    nq(n, 0, qLocs, Array[Array[String]]()).map(x => x.toList).toList
  }

  def nq(n: Int, r: Int, qLocs: Array[Int], allBrds: Array[Array[String]]):
      Array[Array[String]] ={
    if (r == n) {
      updateBoards(qLocs, allBrds)
    } else {
      var newBrds: Array[Array[String]] = allBrds
      for (col <- 0 until n) {
        qLocs(r) = col
        newBrds = if (isValid(qLocs, r)) nq(n, r+1, qLocs, newBrds) else newBrds
      }
      newBrds
    }
  }

  def isValid(qLocs: Array[Int], row: Int): Boolean = {
    (0 until row).
      map(idx => (qLocs(idx) != qLocs(row)) &&
        Math.abs(qLocs(row)-qLocs(idx)) != (row - idx)).
      reduceLeftOption(_ && _).
      getOrElse(true)
  }

  def updateBoards(qLocs: Array[Int], allBrds: Array[Array[String]]):
    Array[Array[String]] = {
    var brd: Array[String] = Array()
    for(x <- 0 until qLocs.length) {
      brd = brd :+ getRow(qLocs.length, qLocs(x))
    }
    allBrds :+ brd
  }
}
