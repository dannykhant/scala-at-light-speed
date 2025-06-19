package com.saanay

object PatternMatching extends App{
  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "1st"
    case 2 => "2nd"
    case 3 => "3rd"
    case _ => anInteger + "th"
  }
  // PM is an expression

  // case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 33) // Person.apply("Bob", 33)

  val personGreeting = bob match {
    case Person(n, a) => s"I'm $n and $a yo"
    case _ => "Unknown"
  }

  // deconstructing tuples
  val aTuple = ("Max", "Dog")
  val animalDescription = aTuple match {
    case (name, breed) => s"$name is $breed"
    case _ => "Unknown"
  }

  // decomposing list
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => s"List has 2 in the middle"
    case _ => "Unknown list"
  }

  // if PM doesn't match anything, it will throw an error
  // PM will try all cases in sequence
}
