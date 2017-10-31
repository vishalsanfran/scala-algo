package game

import org.scalatest.FunSuite

class Nqueens51_test extends FunSuite{
  test("4 queens") {
    val expVal = List(List(".Q..", "...Q", "Q...", "..Q."),
      List("..Q.", "Q...", "...Q", ".Q.."))
    assert(game.Nqueens51.solutions(4) === expVal)
  }
}
