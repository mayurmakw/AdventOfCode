package com.mayur.flipp.twentytwentytwo

import org.scalatest.flatspec.AnyFlatSpec

class DaySixSpec extends AnyFlatSpec{
  "calculate score" should "return expected results" in {
    val input =Seq(
      "bvwbjplbgvbhsrlpgdmjqwftvncz",
      "nppdvjthqldpwncqszvftbrmjlhg",
      "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
      "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")

    val daySix = new DaySix()
    val actualResult = input.map(daySix.findMarker(_, 4))
    val expectedResult = Seq(5,6,10,11)
    val actualResultII = input.map(daySix.findMarker(_, 14))
    val expectedResultII = Seq(23,23,29,26)
    assert(actualResult === expectedResult )
    assert(actualResultII === expectedResultII )
  }

}
