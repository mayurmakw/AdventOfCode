package com.mayur.flipp.twentytwentytwo

object DayTwo {

  val ROCK = 1
  val PAPER = 2
  val SCISSOR = 3
  val score = Map("X" ->ROCK,"Y"-> PAPER,"Z"->SCISSOR)


  def giveOutcome(a:String, b: String):Long = {
    (a,b) match {
      case ("A","X") => 3
      case ("A", "Y") => 6
      case ("B", "Z") => 6
      case ("B", "Y") => 3
      case ("C","A") => 6
      case ("C", "Z") => 3
      case _ => 0
    }
  }

  def calculateRockPaperScissorScore(input:String):Long = {
    input.split("\n")
      .map(x => x.split("\\s"))
      .map(x => giveOutcome(x(0), x(1)) + score(x(1)))
      .sum
  }
}
