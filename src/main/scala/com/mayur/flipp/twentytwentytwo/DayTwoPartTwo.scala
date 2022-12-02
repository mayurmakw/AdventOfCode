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
  val selection = Map(ROCK-> "A",PAPER ->"B", SCISSOR ->"C")

  def makeSelection(a:String, b:String):String = {
    val id = (score(a),score(b)) match {
      case(ROCK,LOSE)=> SCISSOR
      case(ROCK,WIN) => PAPER
      case (PAPER,LOSE)=> ROCK
      case (PAPER,WIN)=> SCISSOR
      case (SCISSOR,LOSE) => PAPER
      case (SCISSOR,WIN)=> ROCK
      case (_, DRAW) => score(a)
    }
    selection(id)
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
