package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.DayOnePartTwo._
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec

class DayOnePartTwoSpec extends AnyFlatSpec
  with BeforeAndAfterAll {

  "Get sum of Three Elf with Max stocking" should "return expected results" in {
    val input =
      """1000
        |2000
        |3000
        |
        |4000
        |
        |5000
        |6000
        |
        |7000
        |8000
        |9000
        |
        |10000
        |""".stripMargin
    val actualResult = getTopThreeElfWithMaxStock(input)
    assert(actualResult === 45000)

  }

}