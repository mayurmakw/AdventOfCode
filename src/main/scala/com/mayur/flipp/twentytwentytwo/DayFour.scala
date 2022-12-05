package com.mayur.flipp.twentytwentytwo

import scala.io.Source

class DayFour {

  def getSection(input: String):Array[(Array[Int], Array[Int])] = {
    input.split("\n")
      .map(x => x.split(","))
      .map(x => (x(0).split("-").map(_.toInt), x(1).split("-").map(_.toInt)))
  }

  def getOverlappingSection(input: String):Long = {
      getSection(input)
      .count(x => (x._1(0) >= x._2(0) && x._1(1) <= x._2(1)) || (x._1(0) <= x._2(0) && x._1(1) >= x._2(1)))
  }

  def getAnyOverlappingSection(input: String):Long = {
    getSection(input)
      .count(x => (x._1(0) <= x._2(0) && x._2(0) <= x._1(1)) || (x._2(0) <= x._1(0) && x._1(0) <= x._2(1)))
  }

}
object  DayFour extends App {
  val resource = Source.fromResource("./day4.txt")
  val input = resource.getLines.mkString("\n")
  val dayFour = new DayFour()
  val result = dayFour.getOverlappingSection(input)
  val partTwo = dayFour.getAnyOverlappingSection(input)
  println(result, partTwo)
}