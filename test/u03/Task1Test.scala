package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List._

class Task1Test {
  @Test def testDrop(): Unit = {
    val lst = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst,1))
    assertEquals(Cons(30, Nil()), drop(lst,2))
    assertEquals(Nil(), drop(lst,5))
  }
}
