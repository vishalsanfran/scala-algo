package graph

import org.scalatest.FunSuite

class UndirectedGraph_test extends FunSuite {
  test("can create 3 adj list graph") {
    val flightList = List("sfo lhr", "lhr bom", "fra sfo", "lhr auh", "auh bom",
      "sfo del", "del bom")
    val adjlist = graph.UndirectedGraph.create_adjlist(flightList.iterator)
    assert(adjlist.getOrElse("sfo", "") === Set("lhr", "del", "fra"))
  }
}
