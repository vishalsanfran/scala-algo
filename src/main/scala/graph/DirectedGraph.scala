package graph

import scala.collection.mutable

object DirectedGraph {
  def create_adjlist(it: Iterator[String]): mutable.Map[String, mutable.Set[String]] = {
    val graph = new mutable.HashMap[String, mutable.Set[String]]()
    while(it.hasNext) {
      val tuple = it.next().trim().split("\\s+")
      val curSet = graph.getOrElse(tuple.head, mutable.Set())
      curSet.add(tuple.last)
      graph.put(tuple.head, curSet)
      if (!graph.contains(tuple.last))
        graph.put(tuple.last, mutable.Set())
    }
    graph
  }
}
