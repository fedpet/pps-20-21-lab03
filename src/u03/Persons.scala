package u03

import Lists.List
import Lists.List._

sealed trait Person
object Persons {
  case class Student(name: String, year: Int) extends Person
  case class Teacher(name: String, course: String) extends Person
  def name (p: Person): String = p match {
    case Student(n, _) => n
    case Teacher(n, _) => n
  }

  def onlyCourses(l: List[Person]): List[String] = flatMap(l) {
    case Teacher(_, c) => Cons(c, Nil())
    case _ => Nil()
  }
}