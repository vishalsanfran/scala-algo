package linkedList

case class Node[T](var data: T, var next: Node[T])

//class LinkedList {
//  var root: Node[String] = _
//}

object LinkedList {
  def apply(it: Iterator[String]=null): Node[String] = {
    var root = new Node[String](null, null)
    if (it == null) {
      return root
    }
    var cur = root.next
    var prev = root
    while(it.hasNext) {
      cur = new Node[String](it.next(), null)
      prev.next = cur
      prev = cur
      cur = cur.next
    }
    root = root.next
    root
  }
}
