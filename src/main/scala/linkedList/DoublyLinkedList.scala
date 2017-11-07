package linkedList

case class DNode[T](var data: T, var next: DNode[T], var prev: DNode[T])

object DoublyLinkedList {
  def create(it: Iterator[String]): (DNode[String], DNode[String]) = {
    var root = new DNode[String]("", null, null)
    if (it == null) {
      return (root, root)
    }
    var prev = root
    var cur = root.next
    while(it.hasNext) {
      cur = new DNode[String](it.next(), null, prev)
      prev.next = cur
      prev = cur
    }
    root = root.next
    root.prev = null
    (root, cur)
  }
}
