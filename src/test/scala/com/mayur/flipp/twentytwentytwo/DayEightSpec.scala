package com.mayur.flipp.twentytwentytwo

import org.scalatest.flatspec.AnyFlatSpec

class DayEightSpec extends AnyFlatSpec{
  "process directory data" should "return expected results" in {
    val input =
      """30373
        |25512
        |65332
        |33549
        |35390
        |""".stripMargin
    val dayEight = new DayEight()
    val (actualResult, actualResult2) = dayEight.processMap(input.split("\n").toList)
    assert(actualResult === 21)
    assert(actualResult2 === 8)
  }
}
