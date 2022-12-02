package com.mayur.flipp.twentytwentytwo

import scala.io.Source

object DayTwoPartTwo {

  val ROCK = 1
  val PAPER = 2
  val SCISSOR = 3
  val WIN = 6
  val LOSE = 0
  val DRAW = 3
  val score = Map("A"-> ROCK, "B"-> PAPER, "C" -> SCISSOR, "X"-> LOSE, "Y"-> DRAW, "Z"-> WIN)

  def makeSelection(a:String, b:String):String = {
    (score(a),score(b)) match {
      case(ROCK,LOSE)=> "C"
      case(ROCK,WIN) => "B"
      case (PAPER,LOSE)=> "A"
      case (PAPER,WIN)=> "C"
      case (SCISSOR,LOSE) => "B"
      case (SCISSOR,WIN)=>"A"
      case (_, DRAW) => a
    }
  }

  def giveOutcome(a:String, b: String):Long = {
    (score(a),score(b)) match {
      case (ROCK,PAPER) => WIN
      case (PAPER,SCISSOR) => WIN
      case (SCISSOR,ROCK) => WIN
      case(x,y) => if(x == y) DRAW else LOSE
    }
  }

  def calculateRockPaperScissorScore(input:String):Long = {
    input.split("\n")
      .map(x => x.split("\\s"))
      .map(x => {
        val selection= makeSelection(x(0),x(1))
        giveOutcome(x(0),selection ) + score(selection)
      })
      .sum
  }

  def main(args: Array[String]): Unit = {
    val resource = Source.fromResource("./day2input.txt")
    val input = resource.getLines
    println(input)
    println(calculateRockPaperScissorScore(input.mkString("\n")))
  }

}
