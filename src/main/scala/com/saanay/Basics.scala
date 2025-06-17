package com.saanay

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 35

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false

  // string and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 1 + 3

  // if-expressions
  val ifExpression = if (meaningOfLife > 30) true else false
  val chainedIfExpression = {
    if (meaningOfLife > 30) 33
    else if (meaningOfLife < 0) -5
    else if (meaningOfLife > 111) 9
    else 0
  }

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 21
    // value of a block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def aFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive function
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  // in Scala, we don't use loops or iterations, we use RECURSION!!!

  // the Unit type = no meaningful value
  // type of Side Effect
  println("I love Scala")

  def anUnitReturningFunction(): Unit = {
    println("Unit is returned")
  }

  val theUnit = ()
}
