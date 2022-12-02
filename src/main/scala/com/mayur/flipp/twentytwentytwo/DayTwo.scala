package com.mayur.flipp.twentytwentytwo

object DayTwo {

  val ROCK = 1
  val PAPER = 2
  val SCISSOR = 3
  val score = Map("X" ->ROCK,"Y"-> PAPER,"Z"->SCISSOR, "A"-> ROCK, "B"-> PAPER, "C" -> SCISSOR)


  def giveOutcome(a:String, b: String):Long = {
      (score(a),score(b)) match {
        case (ROCK,PAPER) => 6
        case (PAPER,SCISSOR) => 6
        case (SCISSOR,ROCK) => 6
        case(x,y) => if(x == y) 3 else 0
    }
  }

  def calculateRockPaperScissorScore(input:String):Long = {
    input.split("\n")
      .map(x => x.split("\\s"))
      .map(x => giveOutcome(x(0), x(1)) + score(x(1)))
      .sum
  }
}
