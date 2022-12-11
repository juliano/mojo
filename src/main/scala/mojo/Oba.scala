// package mojo

// inline def logged[T](level: Int, message: => String)(inline op: T): T =
//   println(s"[$level]Computing $message")
//   val res = op
//   println(s"[$level]Result of $message: $res")
//   res

// class Logger:
//   def log(x: Any): Unit = println(x)

// class RefinedLogger extends Logger:
//   override def log(x: Any): Unit = println("Any: " + x)
//   def log(x: String): Unit = println("String: " + x)

// inline def logged[T](logger: Logger, x: T): Unit =
//   logger.log(x)

// import scala.compiletime.{ codeOf, error }

// inline def doSomething(inline mode: Boolean): Unit =
//   error("Mode must be a known value but got: " + codeOf(mode))

// import scala.quoted.*

// def inspectCode[T](x: Expr[T])(using Type[T], Quotes): Expr[T] =
//   println(x.show)
//   x

// inline def inspect[T](inline x: T): T = ${ inspectCode('x) }