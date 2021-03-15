package u03

object Streams {
  import Lists._
  sealed trait Stream[A]

  object Stream {
    private case class Empty[A]() extends Stream[A]
    private case class Cons[A](head: () => A, tail: () => Stream[A]) extends Stream[A]

    def empty[A](): Stream[A] = Empty()

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }

    def toList[A](stream: Stream[A]): List[A] = stream match {
      case Cons(h,t) => List.Cons(h(), toList(t()))
      case _ => List.Nil()
    }

    def map[A, B](stream: Stream[A])(f: A => B): Stream[B] = stream match {
      case Cons(head, tail) => cons(f(head()), map(tail())(f))
      case _ => Empty()
    }

    def filter[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match {
      case Cons(head, tail) if (pred(head())) => cons(head(), filter(tail())(pred))
      case Cons(head, tail) => filter(tail())(pred)
      case _ => Empty()
    }

    def take[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
      case (Cons(head, tail), n) if n>0 => cons(head(), take(tail())(n - 1))
      case _ => Empty()
    }

    def iterate[A](init: => A)(next: A => A): Stream[A] = cons(init, iterate(next(init))(next))

    def drop[A](s: Stream[A])(n: Int): Stream[A] = s match {
      case Cons(_, t) if n > 0 => drop(t())(n-1)
      case Cons(h, t) if n <= 0 => cons(h(), drop(t())(n))
      case _ => Empty()
    }

    def constant[A](value: A): Stream[A] = cons(value, constant(value))
  }

  import Stream.cons
  def fib(): Stream[Int] = {
      def fib2(a: Int, b: Int): Stream[Int] = cons(b, fib2(b, a+b))
      cons(0, fib2(0, 1))
  }
}