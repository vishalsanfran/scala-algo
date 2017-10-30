package graph

import scala.collection.mutable

object UndirectedGraph {
  def create_adjlist(it: Iterator[String]): mutable.Map[String, mutable.Set[String]] = {
    val graph = new mutable.HashMap[String, mutable.Set[String]]()
    while(it.hasNext) {
      val tuple = it.next().trim().split("\\s+")
      var curSet = graph.getOrElse(tuple.head, mutable.Set())
      curSet.add(tuple.last)
      graph.put(tuple.head, curSet)
      curSet = graph.getOrElse(tuple.last, mutable.Set())
      curSet.add(tuple.head)
      graph.put(tuple.last, curSet)
    }
    graph
  }
}
