package linkedList

import org.scalatest.FlatSpec

class RotateList61_test extends FlatSpec {
  it should "rotate list of 3 elements" in  {
    val cityList = List("sunnyvale", "dublin", "sanfrancisco")
    var root = linkedList.LinkedList(cityList.iterator)
    root = linkedList.RotateList61.rotate(root, 1)
    assert(root.data === cityList.last)
    while(root.next != null) root = root.next
    assert(root.data === cityList(cityList.size-2))
  }
}
