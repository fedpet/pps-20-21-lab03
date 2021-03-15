package u03

import u02.Optionals.Option.{None, Some, getOrElse}
import u02.Optionals.Option

object Lists {

  // A generic linkedlist
  sealed trait List[E]

  // a companion object (i.e., module) for List
  object List {
    case class Cons[E](head: E, tail: List[E]) extends List[E]
    case class Nil[E]() extends List[E]

    def sum(l: List[Int]): Int = l match {
      case Cons(h, t) => h + sum(t)
      case _ => 0
    }

    def append[A](l1: List[A], l2: List[A]): List[A] = (l1, l2) match {
      case (Cons(h, t), l2) => Cons(h, append(t, l2))
      case _ => l2
    }

    def map[A,B](l: List[A])(mapper: A=>B): List[B] = flatMap(l)(e => Cons(mapper(e), Nil()))

    def filter[A](l1: List[A])(pred: A=>Boolean): List[A] = flatMap(l1)({
      case e if pred(e) => Cons(e, Nil())
      case _ => Nil()
    })

    def drop[A](l: List[A], n: Int): List[A] = l match {
      case Cons(_, t) if n > 0 => drop(t, n-1)
      case Cons(h, t) if n <= 0 => Cons(h, drop(t, n))
      case _ => Nil()
    }

    def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case Nil() => Nil()
    }

    def max(l: List[Int]): Option[Int] = l match {
      case Cons(h, t) if h >= getOrElse(max(t), h) => Some(h)
      case Cons(_, t) => max(t)
      case _ => None()
    }
  }
}

object ListsMain extends App {
  import Lists._
  val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
  println(List.sum(l)) // 60
  import List._
  import u03.Lists.List
  println(append(Cons(5, Nil()), l)) // 5,10,20,30
  println(filter[Int](l)(_ >=20)) // 20,30
}