package com.mayur.flipp.twentytwentytwo

import scala.io.Source

object DayOnePartTwo {

  def getTopThreeElfWithMaxStock(input: String): Long = {
    input
      .split("\n")
      .toList
      .foldRight(List(0L))((calories, acc) => if (calories == "") List(0L) ++ acc else List(acc.head + calories.toLong) ++ acc.tail)
      .sorted
      .reverse
      .slice(0, 3)
      .sum
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("./day1input.txt")
    val input = resource.getLines
    println(getTopThreeElfWithMaxStock(input.mkString("\n")))
  }
}
