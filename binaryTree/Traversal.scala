import scala.io.StdIn._
import Console.println

case class Node[T](var data: T, var left: Node[T], var right: Node[T])

class BinaryTree(var root: Node[String] = null) {
  def createTree(it: Iterator[String]): Node[String] = {
    if(it.hasNext) root = new Node(it.next, null, null)
    var queue = List(root)
    while (queue.size > 0) {
      var cur = queue.head
      if(it.hasNext) {
        val nxt = it.next
        if(nxt.nonEmpty) {
          cur.left = new Node(nxt, null, null)
          queue = queue :+ cur.left
        } else {
          cur.left = null
        }
      }
      if(it.hasNext) {
        val nxt = it.next
        if(nxt.nonEmpty) {
          cur.right = new Node(nxt, null, null)
          queue = queue :+ cur.right
        } else {
          cur.right = null
        }
      }
      queue = queue.drop(1)
    }
    root
  }

  def preorder(node: Node[String], op: Node[String] => Unit): Unit = {
    if (node == null) return
    op(node)
    preorder(node.left, op)
    preorder(node.right, op)
  }
  def postorder(node: Node[String], op: Node[String] => Unit): Unit = {
    if (node == null) return
    postorder(node.left, op)
    postorder(node.right, op)
    op(node)
  }
  def inorder(node: Node[String], op: Node[String] => Unit): Unit = {
    if (node == null) return
    inorder(node.left, op)
    op(node)
    inorder(node.right, op)
  }
}


object Traverse extends App {
  println("Binary tree traversals")
  val lines = Iterator.continually(readLine()).takeWhile(( _ != null))
  val nums = lines.map(x => x.trim)

  val bt = new BinaryTree
  val root = bt.createTree(nums)
  val op = (x: Node[String]) => print(x.data + " ")
  println("Preorder")
  bt.preorder(root, op)
  println("\nPostorder")
  bt.postorder(root, op)
  println("\nInorder")
  bt.inorder(root, op)
  println
}
