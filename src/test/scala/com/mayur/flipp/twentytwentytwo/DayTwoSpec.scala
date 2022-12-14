package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.DayTwo._
import org.scalatest.flatspec.AnyFlatSpec

class DayTwoSpec extends AnyFlatSpec {

  "Rock paper scissor" should "return expected results" in {
    val input =
      """A Y
        |B X
        |C Z
        |""".stripMargin
    val actualResult = calculateRockPaperScissorScore(input)
    assert(actualResult === 15L)
  }

}
