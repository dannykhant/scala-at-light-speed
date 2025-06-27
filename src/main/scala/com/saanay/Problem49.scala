package com.saanay

object Problem49 {

  // merge strings alternately
  def mergeAlternately(word1: String, word2: String): String = {
    val result = new StringBuilder
    for ((x, y) <- word1.zipAll(word2, "", "")) {
      result ++= s"$x$y"
    }
    result.toString
  }

  // find the difference
  def findTheDifference(s: String, t: String): Char = {
    val ss = s.sorted
    val ts = t.sorted
    val pairs = ss.zipAll(ts, "", "")
    val cs = pairs.collectFirst { case (x, y) if x != y => y }.get
    val c: Char = cs match {
      case ch: Char => ch
      case str: String => str.head
    }
    c
  }

}
