package com.mayur.flipp.twentytwentytwo

import scala.io.Source

class DayFour {

  def getOverlappingSection(input: String):Long = {
    input.split("\n")
      .map(x => x.split(","))
      .map(x => (x(0).split("-").map(_.toInt), x(1).split("-").map(_.toInt)))
      .count(x => (x._1(0) >= x._2(0) && x._1(1) <= x._2(1)) || (x._1(0) <= x._2(0) && x._1(1) >= x._2(1)))
  }

}
object  DayFour extends App {
  val resource = Source.fromResource("./day4.txt")
  val input = resource.getLines.mkString("\n")
  val result = new DayFour().getOverlappingSection(input)
  println(result)
}