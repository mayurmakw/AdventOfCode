package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.DayOne.getElfWithMaxStock
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec

class DayOneSpec  extends AnyFlatSpec
with BeforeAndAfterAll {

  "Get Elf with Max stocking" should "return expected results" in {
  val input = """1000
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
    val actualResult = getElfWithMaxStock(input)
    assert(actualResult._1 === 24000)
    assert(actualResult._2 === 4)

}
}