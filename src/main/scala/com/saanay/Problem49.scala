package com.saanay

object Problem49 {
  // merge strings alternately
  object Solution {
    def mergeAlternately(word1: String, word2: String): String = {
      val result = new StringBuilder
      for ((x, y) <- word1.zipAll(word2, "", "")) {
        result ++= s"$x$y"
      }
      result.toString
    }
  }
}
