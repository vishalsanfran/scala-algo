package linkedList

import org.scalatest.FunSuite

class LinkedListCreate extends FunSuite{
  test("Create list of 3 items") {
    val cityList = List("sunnyvale", "dublin", "sanfrancisco")
    var ll = linkedList.LinkedList(cityList.iterator)
    assert(ll.data === cityList.head)
    assert(ll.next !== null)
    ll = ll.next
    assert(ll.data === cityList(1))
    assert(ll.next !== null)
    ll = ll.next
    assert(ll.data === cityList(2))
    assert(ll.next === null)
  }
  test("Create empty list when no arg is passed") {
    val ll = linkedList.LinkedList()
    assert(ll.data === null)
    assert(ll.next === null)
  }
}
