package com.mayur.flipp.twentytwentytwo

import org.scalatest.flatspec.AnyFlatSpec

class DaySevenSpec extends AnyFlatSpec {
  "process directory data" should "return expected results" in {
    val input =
      """$ cd /
        |$ ls
        |dir a
        |14848514 b.txt
        |8504156 c.dat
        |dir d
        |$ cd a
        |$ ls
        |dir e
        |29116 f
        |2557 g
        |62596 h.lst
        |$ cd e
        |$ ls
        |584 i
        |$ cd ..
        |$ cd ..
        |$ cd d
        |$ ls
        |4060174 j
        |8033020 d.log
        |5626152 d.ext
        |7214296 k
        |""".stripMargin
    val daySeven = new DaySeven()
    val actualResult = daySeven.sumOfTotalSizeLessonThreshold(input.split("\n").toList)
    assert(actualResult === 95437)
    val actualResultII = daySeven
      .getDirectorySizeTobeDeleted(input.split("\n").toList, 70000000, 30000000)
    assert(actualResultII === 24933642)
  }
}
