package linkedList

object RotateList61 {
  def rotate(root: Node[String], k: Int): Node[String] = {
    if (root == null || root.next == null) return root
    var cur = root
    var cnt = 1
    var totlen = 1
    while(cur.next != null) {
      cur = cur.next
      totlen = totlen + 1
    }
    val lastNode = cur
    val kmod = k % totlen
    if (kmod == 0) return root
    cur = root
    var len = 1
    while(len < (totlen - kmod)) {
      cur = cur.next
      len = len + 1
    }
    val rootRet = cur.next
    cur.next = null
    lastNode.next = root
    rootRet
  }
}
