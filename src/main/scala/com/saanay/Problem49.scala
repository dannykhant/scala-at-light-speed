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

  // find the idx of first occurrence
  def strStr(haystack: String, needle: String): Int = {
    val m = haystack.indices.filter {
      i => haystack.slice(i, i + needle.length) == needle
    }
    if (m.nonEmpty) m(0) else -1
  }

  // valid anagram
  def isAnagram(s: String, t: String): Boolean = {
    s.sorted == t.sorted
  }

  // repeated substring pattern
  def repeatedSubstringPattern(s: String): Boolean = {
    (1 to s.length / 2).exists { n =>
      s.grouped(n).toList.distinct.size == 1
    }
  }

  // move zeros
  def moveZeroes(nums: Array[Int]): Unit = {
    for (t <- 0 until nums.size - 1) {
      for (i <- nums.indices) {
        if (nums(i) == 0 && i < nums.size - 1) {
          val temp = nums(i + 1)
          nums(i + 1) = 0
          nums(i) = temp
        }
      }
    }
  }
}
