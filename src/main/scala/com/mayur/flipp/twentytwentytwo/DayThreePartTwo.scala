package com.mayur.flipp.twentytwentytwo

import scala.io.Source

class DayThreePartTwo {

  def getBadge(input: Array[Array[Char]]): Long = {
    val firstRucksack = input(0).map(x => (x, if (x.isUpper) x.toInt - 65 + 27 else x.toInt - 97 + 1)).toMap
    val secondRucksack = input(1).map(x => (x, firstRucksack.get(x))).filter(_._2.isDefined).toMap
    input(2)
      .dropWhile(x => !secondRucksack.contains(x))
      .take(1)
      .map(firstRucksack.getOrElse(_, 0))
      .sum
  }

  def getBadgeDynamicSize(input: Array[Array[Char]]):Long = {
    input.reduce(_ intersect _)
      .map(x =>if (x.isUpper) x.toInt - 65 + 27 else x.toInt - 97 + 1)
      .take(1)
      .sum
  }

  def getSumOfPriorityForBadges(input: String): Long = {
    input.split("\n")
      .grouped(3)
      .map(x => x.map(_.toCharArray))
      .map(getBadgeDynamicSize)
      .sum

  }

}

object DayThreePartTwo extends App {
  val dayThreeProcessor = new DayThreePartTwo()
  val resource = Source.fromResource("./day3.txt")
  val input = resource.getLines.mkString("\n")
  val result = dayThreeProcessor.getSumOfPriorityForBadges(input)
  print(result)

}
