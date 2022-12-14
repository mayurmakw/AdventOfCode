package com.mayur.flipp.twentytwentytwo

import scala.io.Source

object DayOne {

  def getElfWithMaxStock(input: String): (Long, Int) = {
    input
      .split("\n")
      .toList
      .foldRight(List(0L))((calories, acc) => if (calories == "") List(0L) ++ acc else List(acc.head + calories.toLong) ++ acc.tail)
      .zipWithIndex
      .map(x => (x._1, x._2 + 1))
      .maxBy(_._1)
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("./day1input.txt")
    val input = resource.getLines
    println(getElfWithMaxStock(input.mkString("\n")))
  }
}
