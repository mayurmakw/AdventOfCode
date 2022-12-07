package com.mayur.flipp.twentytwentytwo

import com.mayur.flipp.twentytwentytwo.util.ReadFileUtil

import scala.io.Source


class DaySeven {

  case class File(name: String, size: Long, location: List[String])
  case class DaySevenState(current: List[String], files: List[File])


  def parseCommand(input: String, current: List[String]): List[String] = {
    input.drop(2) match {
      case "cd .." => current.tail
      case "cd /" => List("/")
      case s"cd $x" => s"${current.head}/$x" :: current
      case _ => current
    }
  }

  def parseOutput(input: String, current: List[String], files: List[File]): List[File] = {
    val output = input.split("\\s")
    (output(0).toLongOption, output(1)) match {
      case (Some(size), name) => {
        File(name = name, size = size, location = current) :: files
      }
      case _ => files
    }
  }

  def processInput(input: List[String]): Map[String,Long] = {
    input
      .foldLeft(DaySevenState(List.empty, List.empty))((acc, item) => {
        if (item.startsWith("$")) {
          acc.copy(current = parseCommand(item, acc.current))
        }
        else {
          acc.copy(files = parseOutput(item, acc.current, acc.files))
        }
      })
      .files
      .flatMap(x => {
      x.location.map((_, x.size))
    })
      .groupBy(_._1)
      .map(x => (x._1, x._2.map(_._2).sum))
  }

  def sumOfTotalSizeLessonThreshold(input: List[String], threshold: Long = 100000): Long = {
    processInput(input).values.filter(_ <= threshold).sum
  }

  def getDirectorySizeTobeDeleted(input: List[String], totalSpace: Long, spaceToBeFreed:Long ):Long= {
    val directoryWithSize = processInput(input)
    val rootSize = directoryWithSize.getOrElse("/",0L)
    val sizeToBeDeleted:Long = spaceToBeFreed- (totalSpace - rootSize )
    directoryWithSize
      .values
      .filter(_ >= sizeToBeDeleted)
      .min

  }
}
object DaySeven extends App with ReadFileUtil {
  val fileName = "day7.txt"
  val daySeven = new DaySeven()
  val result = daySeven.sumOfTotalSizeLessonThreshold(input,100000)
  val resultII = daySeven.getDirectorySizeTobeDeleted(input,totalSpace = 70000000, 30000000)
  print(result, resultII)
}


