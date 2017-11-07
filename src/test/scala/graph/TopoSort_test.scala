package graph

import org.scalatest.FunSuite

class TopoSort_test extends FunSuite{
  test("topo sort on acyclic graph") {
    val flightList = List("sfo lhr", "lhr bom", "fra sfo", "lhr auh", "auh bom",
      "sfo del", "del bom")
    val adjList = graph.DirectedGraph.create_adjlist(flightList.iterator)
    val topoList = new graph.TopoSort(adjList).run
    assert(topoList === List("fra", "sfo", "del", "lhr", "auh", "bom"))
  }

  test("topo sort on cyclic graph fails") {
    val flightList = List("sfo lhr", "lhr bom", "fra sfo", "lhr auh", "auh bom",
      "sfo del", "del bom", "lhr sfo")
    val adjList = graph.DirectedGraph.create_adjlist(flightList.iterator)
    assertThrows[Exception](
      new graph.TopoSort(adjList).run
    )
  }
}
