package com.mayur.flipp.twentytwentytwo

import scala.annotation.tailrec
import scala.io.Source

class DaySix {

  def findMarker(input: String,markerSize:Int): Int = {
    @tailrec
    def _findMarker(data: Array[Char], acc: List[Char] = List.empty, idx: Int = 1): Int = {
      val item = acc.zipWithIndex.find(x => x._1 == data.head)
      (item, acc.length == markerSize-1) match {
        case (None,true ) => idx
        case (None, _) => _findMarker(data.tail, data.head :: acc, idx + 1)
        case (Some(x), _) => _findMarker(data.tail, data.head :: acc.take(x._2) ,idx+1)
      }
    }
    _findMarker(input.toCharArray)
  }
}
  object DaySix extends App {
    val resource = Source.fromResource("./day6.txt")
    val input = resource.getLines.mkString("/n")
    val daySix = new DaySix()
    val MARKER_SIZE=4
    val result = daySix.findMarker(input, MARKER_SIZE)
    val MARKER_SIZE_II=14
    val result2 = daySix.findMarker(input,MARKER_SIZE_II)
    println(result, result2)
  }