package com.mayur.flipp.twentytwentytwo

import org.scalatest.flatspec.AnyFlatSpec

class DayFiveSpec extends AnyFlatSpec{
  "process stack data" should "return expected results" in {
    val input =
      """    [D]
        |[N] [C]
        |[Z] [M] [P]
        | 1   2   3
        |
        |move 1 from 2 to 1
        |move 3 from 1 to 3
        |move 2 from 2 to 1
        |move 1 from 1 to 2
        |""".stripMargin
    val actualResult = new DayFive().moveCrate(input)
    val expectedResult = "CMZ"
    assert(actualResult === expectedResult )

  }
}
