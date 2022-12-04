package com.mayur.flipp.twentytwentytwo


import scala.io.Source

object DayThree {

  def findPriority(a: Array[Char], b: Array[Char]): Long = {
    val firstItemMap = a.map(x => (x, if (x.isUpper) x.toInt - 65 + 27 else x.toInt - 97 + 1)).toMap
    val output = b
      .map(x => firstItemMap.get(x))
      .dropWhile(_.isEmpty)
      .take(1)
      .map(_.getOrElse(0))
      .sum
    output
  }

  def getSumOfPriorities(input: String): Long = {
    input.split("\n")
      .map(x => {
        val inputChars = x.toCharArray
        inputChars.splitAt(inputChars.length / 2)
      })
      .map(x => findPriority(x._1, x._2))
      .sum
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("./day3.txt")
    val input = resource.getLines
    println(getSumOfPriorities(input.mkString("\n")))
  }
}
