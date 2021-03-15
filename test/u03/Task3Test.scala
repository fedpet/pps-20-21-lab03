package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream._

class Task3Test {
  private val s = take(iterate(0)(_ +1))(10)

  @Test def testDrop() {
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), toList(drop(s)(6)))
  }

  @Test def testConstant() {
    assertEquals(Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil()))))), toList(take(constant("x"))(5)))
  }


}
