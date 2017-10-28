package linkedList

import org.scalatest.FunSuite

class ReverseLinkedList206_test extends FunSuite {
  test("reverse LL with 3 items") {
    val cityList = List("sunnyvale", "dublin", "sanfrancisco")
    var root = linkedList.LinkedList(cityList.iterator)
    root = linkedList.ReverseLinkedList206.reverse(root)
    assert(root.data === cityList.last)
  }
}
