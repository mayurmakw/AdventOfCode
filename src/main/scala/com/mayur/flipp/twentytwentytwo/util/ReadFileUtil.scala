package com.mayur.flipp.twentytwentytwo.util

import scala.io.Source

trait ReadFileUtil {
  val fileName:String

  lazy val resource = Source.fromResource(s"./$fileName")
  lazy val input:List[String] = resource.getLines.toList

}
