package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.Cons
import u03.Lists.List.Nil

class Task2Test {
  @Test def testOnlyCourses() {
    val l = Cons(Student("S1", 2018), Cons(Teacher("T1", "C1"), Cons(Student("S2", 2000), Cons(Teacher("T2", "C2"), Nil()))))
    assertEquals(Cons("C1", Cons("C2", Nil())), onlyCourses(l))
  }
}
