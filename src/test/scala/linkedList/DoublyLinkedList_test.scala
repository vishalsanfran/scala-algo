package linkedList

import org.scalatest.FunSuite

class DoublyLinkedList_test extends FunSuite{
  test("Create double linked list of 3 items") {
    val cityList = List("sunnyvale", "dublin", "sanfrancisco")
    val (head, tail) = linkedList.DoublyLinkedList.create(cityList.iterator)
    assert(head.data === cityList.head)
    assert(head.next !== null)
    assert(head.prev === null)
    assert(tail.data === cityList.last)
    assert(tail.next === null)
    assert(tail.prev !== null)
  }
}
