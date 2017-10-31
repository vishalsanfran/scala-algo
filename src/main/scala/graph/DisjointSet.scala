package graph

import scala.collection.mutable.{Map => MMap}

object blah {

}

class DisjointSet(var rank: MMap[String, Int]=MMap(),
                  var parent: MMap[String, String]=MMap()) {
  def find(x: String): String ={
    var parVal = parent.getOrElse(x, "")
    if (parVal == "") {
      return parVal
    }
    if (parVal != x) {
      parVal = find(parVal)
      parent.put(x, parVal)
    }
    parVal
  }

  def initVal(x: String): Unit= {
    if(!rank.contains(x)) {
      rank.put(x, 0)
      parent.put(x, x)
    }
  }

  def union(x: String, y: String): Unit= {
    initVal(x)
    initVal(y)
    val xParent = find(x)
    val yParent = find(y)
    val xRank = rank.getOrElse(xParent, 0)
    val yRank = rank.getOrElse(yParent, 0)
    if (xRank < yRank) {
      parent.put(x, y)
    } else if (xRank > yRank) {
      parent.put(y, x)
    } else {
      parent.put(y, x)
      rank.put(xParent, xRank + 1)
    }
  }
}
