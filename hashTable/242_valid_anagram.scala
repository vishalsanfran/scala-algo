import Console.println
import scala.collection.mutable.{Map => MMap}
object Solution {
  def isAnagram(s: String, t: String): Boolean= {
    return getCharCountMap(s).equals(getCharCountMap(t))
  }

  def getCharCountMap(s: String): MMap[Char, Int]= {
    var charCountMap = MMap[Char, Int]()
    for(idx <- 0 to s.size-1) {
      val initVal = charCountMap.getOrElse(s(idx), 0)
      charCountMap.put(s(idx), initVal+1)
    }
    return charCountMap
  }
}

object ValidAnagram extends App {
  var inputList = List[String]()
  var readVal = ""
  for(idx <- 0 to 1){
    readVal = scala.io.StdIn.readLine()
    inputList = inputList :+ readVal
  }
  //println(inputList)
  val cond = if (Solution.isAnagram(inputList(0), inputList(1))) " is" else " is not"
  println(inputList(0) + cond + " anagram of " + inputList(1))
}

//test run: echo -e "abcba\naabcb\n" | scala 242_valid_anagram.scala
