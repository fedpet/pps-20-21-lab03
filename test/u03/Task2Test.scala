package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.Modules.Person
import u02.Modules.Person.{Student, Teacher}
import u03.Lists.List
import u03.Lists.List.{Cons, Nil, flatMap}

class Task2Test {
  private def onlyCourses(l: List[Person]): List[String] = flatMap(l) {
    case Teacher(_, c) => Cons(c, Nil())
    case _ => Nil()
  }

  @Test def testOnlyCourses() {
    val l: List[Person] = Cons(Student("S1", 2018), Cons(Teacher("T1", "C1"), Cons(Student("S2", 2000), Cons(Teacher("T2", "C2"), Nil()))))
    assertEquals(Cons("C1", Cons("C2", Nil())), onlyCourses(l))
  }
}
