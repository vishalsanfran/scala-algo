package graph

import org.scalatest.FunSuite

class DisjointSet_test extends FunSuite{
  test("make 2 sets of 2 and 3 items") {
    val dset = new graph.DisjointSet()
    val ca_cities = List("sf", "la", "sac")
    dset.initVal(ca_cities.head)
    dset.union(ca_cities.head, ca_cities(1))
    dset.union(ca_cities.last, ca_cities(1))

    val ny_cities = List("nyc", "alb")
    dset.initVal(ny_cities.head)
    dset.initVal(ny_cities.last)
    dset.union(ny_cities.head, ny_cities.last)

    List(ny_cities, ca_cities).
      foreach(cityList =>
            cityList.foreach(
              x => assert(dset.find(x) === cityList.head))
          )
  }
}
