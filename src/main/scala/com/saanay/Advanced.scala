package com.saanay

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  /*
    lazy evaluation
   */
  lazy val aLazyValue = 3
  lazy val lazyValueWithSideEffect = {
    println("I'm lazy")
    31
  }
  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  /*
    "pseudo-collection": Option, Try
   */
  def methodCanReturnNull(): String = "hello scala"

  /*
    if(methodCanReturnNull() == null) {
      // defensive code against NULL
    }
   */
  val anOption = Option(methodCanReturnNull()) // Some("hello scala")
  // option: collection which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(value) => s"I've obtained a value: $value"
    case None => "I obtained nothing"
  }

  def methodCanThrowException(): String = throw new RuntimeException()

  /*
    try {
      methodCanThrowException()
    } catch {
      case e: Exception => "defend against this exception"
    }
   */
  val aTry = Try(methodCanThrowException())
  // try: collection with either a value if the code went well or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I've obtained a value: $value"
    case Failure(exception) => s"I've obtained an exception: $exception"
  }
  // can be composed with map, flatMap and filter

  /*
    evaluate something on another thread
    asynchronous programming
   */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("Computed a value")
    53
  }
  // future: collection which contains a value when it's evaluated
  // future is composable with map, flatMap and filter
  // monads (to explore this more)

  /*
    implicits
   */
  // #1: implicit arguments
  def methodWithImplicitArg(implicit arg: Int) = arg + 1

  implicit val myImplicitNum = 5
  println(methodWithImplicitArg) // methodWithImplicitArg(myImplicitNum)

  // #2: implicit conversions
  implicit class myRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  print(31.isEven()) // new myRichInteger(31).isEven()
  // USE THESE CAREFULLY
}
