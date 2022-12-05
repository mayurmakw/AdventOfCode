package com.mayur.flipp.twentytwentytwo

import org.scalatest.flatspec.AnyFlatSpec

class DayFourSpec extends AnyFlatSpec {
  "get overlapping section" should "return expected results" in {
    val input =
      """2-4,6-8
        |2-3,4-5
        |5-7,7-9
        |2-8,3-7
        |6-6,4-6
        |2-6,4-8
        |""".stripMargin
    val actualResult = new DayFour().getOverlappingSection(input)
    val actualResultPartTwo = new DayFourPartTwo().getAnyOverlappingSection(input)
    assert(actualResult === 2)
    assert(actualResultPartTwo === 4)
  }
}
