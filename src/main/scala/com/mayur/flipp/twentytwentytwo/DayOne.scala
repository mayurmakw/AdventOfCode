package com.mayur.flipp.twentytwentytwo

import DayOne.input

import scala.util.Try

object DayOne {

  def getElfWithMaxStock(input:String): (Long,Int) = {
    input
      .split("\n")
      .toList
      .foldRight(List(0L))((calories, acc) => if(calories == "" ) List(0L)++ acc else List(acc.head + calories.toLong) ++ acc.tail )
      .zipWithIndex
      .map( x => (x._1, x._2+1))
      .maxBy(_._1)
  }
}
