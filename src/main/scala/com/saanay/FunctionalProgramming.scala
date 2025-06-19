package com.saanay

object FunctionalProgramming extends App {
  // OOP
  class Person(name: String) {
    def apply(age: Int) = println(s"I'm $age yo")
  }

  val bob = new Person("Bob")
  bob.apply(21)
  bob(21) // invoking bob as a function === bob.apply(21)

  /*
    Scala run on JVM
    Functional programming:
      - compose Functions
      - pass Functions as arg
      - return Functions as result
    Conclusion: FunctionX: Function1, Function2, ..., Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(5)
  simpleIncrementer(5) // simpleIncrementer.apply(5)
  // when define a function, ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPE

  // functions with two args and string return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcatenator.apply("I love", " Scala")

  // syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(3)

  /*
  equivalent to this longer form:

  val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = 2 * x
  }
   */

  // higher-order function: take function as arg/ return function as result
  val aMappedList = List(1, 2, 3).map(x => x + 1) // HOF
  val aFlatMappedList = List(1, 2, 3).flatMap {
    x => List(x, x * 2)
  } // alternative syntax, same as .flatMap(x => List(x, x * 2))
  val aFilteredList = List(1, 2, 3).filter(_ % 2 == 0) // equivalent to x => x % 2 == 0

  // all pairs between 1, 2, 3 and 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(num => List('a', 'b', 'c').map(letter => s"$num-$letter"))

  // for comprehension
  val alternativePairs = for {
    num <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$num-$letter"
  // equivalent to the above mapFlatmap chain

  /*
    Collections
   */

  // lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0, 1, 2, 3, 4, 5)
  val anExtendedList = 0 +: aList :+ 6 // List(0, 1, 2, 3, 4, 5, 6)

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElement = aSequence(1) // the element at index 1: 2

  // vectors: FAST Seq implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets: no duplicates
  val aSet = Set(1, 2, 3, 1, 2) // Set(1, 2, 3)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1, 2, 3, 5)
  val aRemovedSet = aSet - 3 // Set(1, 2)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(_ * 2).toList // List(2, 4, 6, ..., 2000)

  // tuples: groups of values under the same value
  val aTuple = ("Max", "Dog", "2015")

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Danny", 1234),
    "Nancy" -> 4567 // ("Nancy", 4567)
  )

}
