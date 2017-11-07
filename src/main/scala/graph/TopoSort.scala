package graph

import scala.collection.mutable

class TopoSort(adjList: mutable.Map[String, mutable.Set[String]]) {
  var topoList: Array[String] = Array()
  var perm: mutable.Set[String] = mutable.Set()
  var tmp: mutable.Set[String] = mutable.Set()
  val cyclicMsg = "Found cyclic graph"

  def run: List[String]= {
    for(key <- adjList.keys) {
      visit(key)
    }
    topoList.toList
  }

  def visit(node: String): Unit= {
    if (perm.contains(node))
      return
    if (tmp.contains(node))
      throw new Exception(cyclicMsg)
    tmp.add(node)
    for (nbor <- adjList.getOrElse(node, mutable.Set())) {
      visit(nbor)
    }
    tmp.remove(node)
    perm.add(node)
    topoList = node +: topoList
  }
}
