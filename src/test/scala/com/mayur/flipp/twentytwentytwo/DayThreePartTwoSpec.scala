package com.mayur.flipp.twentytwentytwo

import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec

class DayThreePartTwoSpec extends AnyFlatSpec
  with BeforeAndAfterAll {

  "Get Sum of badge priority" should "return expected results" in {
    val input =
      """vJrwpWtwJgWrhcsFMMfFFhFp
        |jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        |PmmdzqPrVvPwwTWBwg
        |wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        |ttgJtRGJQctTZtZT
        |CrZsJsPPZsGzwwsLwLmpwMDw
        |""".stripMargin
    val actualResult = new DayThreePartTwo().getSumOfPriorityForBadges(input)
    assert(actualResult === 70)
  }

}