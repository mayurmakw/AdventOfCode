package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.DayThree._
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec

class DayThreeSpec extends AnyFlatSpec
  with BeforeAndAfterAll {

  "Get Sum of priority" should "return expected results" in {
    val input =
      """vJrwpWtwJgWrhcsFMMfFFhFp
        |jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        |PmmdzqPrVvPwwTWBwg
        |wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        |ttgJtRGJQctTZtZT
        |CrZsJsPPZsGzwwsLwLmpwMDw
        |""".stripMargin
    val actualResult = getSumOfPriorities(input)
    assert(actualResult === 157)
  }

}