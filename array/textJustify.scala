import Console.println
import scala.io.Source


object Justify {
  def justify(lines: Vector[String], maxWidth: Integer): List[String]= {
    val words = lines.flatMap(_.split("\\s+"))
    var idx = 0
    var queue = List[String]()
    var curLine = List[String]()
    while (idx < words.length) {
      curLine = List[String]()
      var lineWidth = getMinLineWidth(curLine :+ words(idx))
      while((lineWidth <= maxWidth) && (idx < words.length-1)) {
        curLine = curLine :+ words(idx)
        lineWidth = getMinLineWidth(curLine :+ words(idx+1))
        idx = idx + 1
      }
      if (idx == words.length-1) {
        curLine = curLine :+ words(idx)
        idx = idx + 1
      }
      var justified = justifyOneLine(curLine, maxWidth)
      queue = queue :+ justified
    }
    return queue
  }

  def getMinLineWidth(line: List[String]): Int= {
    return line.length-1 + line.map(_.size).reduceLeftOption(_ + _).getOrElse(0)
  }

  def justifyOneLine(line: List[String], maxWidth: Integer): String= {
    val totalLen = line.map(_.size).reduceLeftOption(_ + _).getOrElse(0)
    var spaces = maxWidth - totalLen
    if (line.length == 1) {
      return line(0) + " "*spaces
    }
    val wordSpace = spaces/(line.length-1)
    var extraSpace = spaces%(line.length-1)
    var idx = 0
    var res = ""
    var curSpace = 0
    for (word <- line) {
      res = res + word
      curSpace = wordSpace
      if (extraSpace > 0) {
        curSpace = curSpace + 1
        extraSpace = wordSpace - 1
      }
      if (idx != line.length-1) {
        res = res + " "*curSpace
      }
      idx = idx + 1
    }
    return res
  }
}

object TextJustify extends App {
  if (args.length == 0)
    throw new Exception("Enter Path for file with text to justify")

  val linesItr = Source.fromFile(args(0)).getLines
  val linesVector = linesItr.toVector
  //println(Justify.justifyOneLine(List("intended", "to", "be", "compiled"), 21))
  println(Justify.justify(linesVector, 21).toString())
  println()
}
