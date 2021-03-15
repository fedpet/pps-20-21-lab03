package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream._
import u03.Streams.fib

class Task3Test {
  @Test def testDrop() {
    val s = take(iterate(0)(_ +1))(10)
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), toList(drop(s)(6)))
  }

  @Test def testConstant() {
    assertEquals(Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil()))))), toList(take(constant("x"))(5)))
  }

  @Test def testFib() {
    assertEquals(Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil())))))))), toList(take(fib())(8)))
  }
}
