import scala.io.StdIn._
import Console.println

class Node[T](var data: T, var left: Node[T], var right: Node[T])

class BinaryTree[T](var root: Node[T] = null) {
  def createTree(it: Iterator[T]): Node[T] = {
    if(it.hasNext) root = new Node(it.next, null, null)
    var queue = List(root)
    while (queue.size > 0) {
      var cur = queue.head
      if(it.hasNext) {
        cur.left = new Node(it.next, null, null)
        queue = queue :+ cur.left
      }
      if(it.hasNext) {
        cur.right = new Node(it.next, null, null)
        queue = queue :+ cur.right
      }
      queue = queue.drop(1)
    }
    root
  }

  def preorder(node: Node[T], op: String => Unit): Unit = {
    if (node == null) return
    op(node.data + " ")
    preorder(node.left, op)
    preorder(node.right, op)
  }
}


object Traverse extends App {
  println("Binary tree traversals")
  val lines = Iterator.continually(readLine()).takeWhile(_ != null)
  val nums = lines.map(x => x.toInt)

  val bt = new BinaryTree[Int]
  val root = bt.createTree(nums)
  bt.preorder(root, print)
}
