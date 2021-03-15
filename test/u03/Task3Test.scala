package u03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List
import u03.Lists.List._
import u03.Streams.Stream
import u03.Streams._

class Task3Test {
  val s = Stream.take(Stream.iterate(0)(_ +1))(10)
  @Test def testDrop(): Unit = {
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), Stream.toList(Stream.drop(s)(6)))
  }
}
