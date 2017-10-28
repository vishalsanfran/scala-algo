package linkedList

object ReverseLinkedList206 {
  def reverse(root: Node[String]): Node[String] = {
    if (root.next == null) return root
    var curRoot = root
    var prev = root
    var cur = prev.next
    prev.next = null
    var save: Node[String] = null
    while(cur != null) {
      save = cur.next
      cur.next = prev
      prev = cur
      cur = save
    }
    curRoot = prev
    curRoot
  }
}
