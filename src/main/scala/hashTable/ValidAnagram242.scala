package hashTable

import scala.collection.mutable.{Map => MMap}

object ValidAnagram242 {
  def isAnagram(s: String, t: String): Boolean= {
    getCharCountMap(s).equals(getCharCountMap(t))
  }

  def getCharCountMap(s: String): MMap[Char, Int]= {
    var charCountMap = MMap[Char, Int]()
    for(idx <- 0 to s.size-1) {
      val initVal = charCountMap.getOrElse(s(idx), 0)
      charCountMap.put(s(idx), initVal+1)
    }
    charCountMap
  }
}

object ValidAnagram242_main extends App {
  var inputList = List[String]()
  var readVal = ""
  for(idx <- 0 to 1){
    readVal = scala.io.StdIn.readLine()
    inputList = inputList :+ readVal
  }
  //println(inputList)
  val cond = if (ValidAnagram242.isAnagram(inputList(0), inputList(1))) " is" else " is not"
  println(inputList(0) + cond + " anagram of " + inputList(1))
}
