package MatthewRalston.mergesorting

import sbt._
import java.io.{File, PrintWriter}
import scala.io.Source

object Mergesorter {
  def main(args: Array[String]) {
    val mergesortVersion = "0.0.1"
    val parser = new scopt.OptionParser[Config]("scopt") {
      head("ScalaSorter", mergesortVersion)
      opt[File]('i', "in") required() valueName("<file>") action { (x, c) =>
        c.copy(in = x) } validate { x =>
        if (x.canRead()) success else failure(s"File $x cannot be read")
      } text("in is a required file")

      opt[File]('o', "out") required() valueName("<file>") action { (x, c) =>
        c.copy(out = x) } text("out is a required file")
      note("some notes.\n")
      version(mergesortVersion)
      help("help") text("prints this usage text")    
    }
    // parser.parse returns Option[C]
    parser.parse(args, Config()) match {
      case Some(config) =>
        // do stuff
        val in = config.in.toString()
        val out = config.out.toString()
        var csv = List[List[Int]]()

        Source.fromFile(new File(in)).getLines.foreach { line =>
          if (!line.isEmpty) {
            csv ::= line.split(",").map(_.toInt).toList
          }
        }


        val sorter = new Mergesort(0)
        val results = sorter.run(csv)
        println(results.toString())

      case None =>
        // arguments are bad, error message will have been displayed
    }
  }
}
