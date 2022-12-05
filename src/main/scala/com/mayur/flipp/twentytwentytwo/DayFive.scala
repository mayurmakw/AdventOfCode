package com.mayur.flipp.twentytwentytwo

import scala.io.Source

case class Move(items: Int, from:Int, to:Int)

class DayFive {

  def processStackData(input: Array[String]): Map[Int,List[String]] = {
    val size = input.map(_.length).max
    input
      .dropRight(1)
      .map(x => x.padTo(size," ").mkString(""))
      .map(x => x.grouped(4).toList)
      .toList
      .transpose
      .map(x => x.filter(_.trim != ""))
      .zipWithIndex
      .map(x => (x._2+1, x._1.map(_.replaceAll("[\\[\\]]","").trim)))
      .toMap
  }
  def parseMoves(input: Array[String])={
    input
      .drop(1)
      .map {
        case s"move $a from $b to $c" => Some(Move(a.toInt, b.toInt, c.toInt))
        case _ => None
      }
      .filter(_.isDefined)
      .map(_.get)
  }


  def moveCrate(input:String, multiple:Boolean= false):String= {
    val stackData = processStackData(input.split("\n").takeWhile(_.trim != ""))
    val moves = parseMoves(input.split("\n").dropWhile(_.trim == ""))

    val output = moves.foldLeft(stackData)((stacks,move)=> {
      val (left, right) = stacks(move.from).splitAt(move.items)
      stacks ++
        Map(move.from -> right, move.to -> ((if(multiple) left else left.reverse) ++ stacks(move.to)))
    })
    output.map(x => (x._1,x._2.head))
      .toList
      .sortBy(_._1)
      .map(_._2).mkString("")
  }
}

object DayFive extends App {
  val resource = Source.fromResource("./day5.txt")
  val input = resource.getLines.mkString("\n")
  val dayFive = new DayFive()
  val result = dayFive.moveCrate(input)
  val resultPart2 = dayFive.moveCrate(input, true)
  println(result, resultPart2)
}