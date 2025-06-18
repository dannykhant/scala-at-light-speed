package com.saanay

object ObjectOrientation extends App {

  // java equivalent to App: public static void main(String[] args)

  // class and instance
  class Animal {
    // define field
    val age: Int = 0

    // define method
    def eat(): Unit = println("I'm eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Hachi")

  // constructor arguments are not fields: need to put a val before the constructor argument
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Max")
  aDeclaredAnimal.eat() // the nearest derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLeg = true // by default public, can restrict by adding protected or private

    def walk(): Unit
  }

  // interface: ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single class inheritance with multi traits
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating Animal")

    override def ?!(thought: String): Unit = println(s"I'm thinking $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation: object method argument, only available for methods with ONE argument
  aCroc ?! "What if we can fly"

  // operators in Scala are actually methods
  val basicMath = 1 + 3
  val anotherBasicMath = 1.+(3)

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("Dinosaur eats a lot")
  }
  /*
    the compiler does:

    class Carnivore_Anonymous_3245 extends Carnivore {
      override def eat(animal: Animal): Unit = println("Dinosaur eats a lot")
    }
    val dinosaur =  Carnivore_Anonymous_3245
  */

  // singleton object
  object MySingleton { // the only instance of MySingleton type
    val mySpecialValue: Int = 33

    def mySpecialMethod(): Int = 5791

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(11)
  MySingleton(11) // equivalent to MySingleton.apply(11)

  object Animal { // companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // static fields/methods

  /*
    case classes are light weight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
  */
  case class Person(name: String, age: Int)

  // can be constructed without the keyword new
  val bob = Person("Bob", 21) // Person.apply("Bob", 21)

  // exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "error message"
  } finally {
    // execute no matter what
  }

  // generics
  abstract class myList[T] {
    def head: T

    def tail: myList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("hello", "scala")
  val firstString = aStringList.head // string

  // point #1: in Scala we operate with immutable values/objects
  // Any modification to an object return another object
  /*
    Benefits:
    - works miracle in multithreaded/distributed env
    - helps making sense of the code on reasoning
   */
  val reversedList = aList.reverse

  // point #2: Scala is closest to the OO ideal
}
