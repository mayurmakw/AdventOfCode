package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.util.ReadFileUtil

import scala.annotation.tailrec

class DayEight {
  case class Visible(distance: Int, isVisible: Boolean)

  def getRecursiveVisible(input: List[Int], acc: List[Visible] = List.empty): List[Visible] = {
    input match {
      case Nil => acc
      case x => {
        val isVisible:Boolean = input.tail.forall(x => x< input.head)
        val distance:Int =input.tail.takeWhile(x =>x < input.head).size + input.tail.dropWhile(x =>x < input.head).take(1).size
        getRecursiveVisible(x.tail, acc ++ List(Visible(distance,isVisible)))
      }
    }
  }

  def isVisible(input: List[Int], direction: String): List[Visible] = {
    direction match {
      case "left" | "top" => getRecursiveVisible(input)
      case "right" | "bottom" => getRecursiveVisible(input.reverse).reverse
    }
  }

  def processMap(input: List[String]):(Int,Int) = {
    val output = input
      .map(x => x.toCharArray.map(x => x.asDigit ).toList)

    val left = output.map(x => isVisible(x, "left"))
    val right = output.map(x => isVisible(x, "right"))
    val top = output.transpose.map(x => isVisible(x, "top")).transpose
    val bottom = output.transpose.map(x => isVisible(x, "bottom")).transpose

    val all = left
      .lazyZip(right)
      .lazyZip(top)
      .lazyZip(bottom)
      .toList
      .flatMap(x => x._1.lazyZip(x._2).lazyZip(x._3).lazyZip(x._4).toList)
      .map(x => {
        Visible(
          distance = x._1.distance*x._2.distance*x._3.distance*x._4.distance,
          isVisible = x._1.isVisible || x._2.isVisible || x._3.isVisible || x._4.isVisible
        )
      })
    (all.count(x => x.isVisible), all.map(_.distance).max)
  }
}

object DayEight extends App with ReadFileUtil {
  val fileName = "day8.txt"
  val dayEight = new DayEight()
  val (result, result2) = dayEight.processMap(input)
  print(result,result2)
}
