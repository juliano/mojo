// package mojo

// import scala.compiletime.{ constValue, erasedValue, summonInline }
// import scala.deriving.Mirror
// import scala.quoted.*

// import java.{ util as ju }

// object From {

//   inline given derived[T]: Any = JavaDecoder.derived

//   def decode[T](jmap: ju.Map[String, AnyRef])(using fj: JavaDecoder[T]): T = {
//     fj.fromJMap(jmap)
//   }

//   trait JavaDecoder[T]:
//     def fromJMap(jmap: ju.Map[String, AnyRef]): T

//   object JavaDecoder:
//     inline def summonInstance[T]: JavaDecoder[T] = summonInline[JavaDecoder[T]]

//     inline def derived[T]: JavaDecoder[T] =
//       inline summonInline[Mirror.Of[T]] match
//         case prod: Mirror.ProductOf[T] =>
//           new JavaDecoder[T]:
//             def fromJMap(jmap: ju.Map[String, AnyRef]): T = ???

//         case sum: Mirror.SumOf[T] =>
//           new JavaDecoder[T]:
//             def fromJMap(jmap: ju.Map[String, AnyRef]): T = ???

//         case _ => throw new IllegalArgumentException(s"Mirror not found")

//     // inline def borala[Names <: Tuple, T <: Product](jmap: ju.Map[String, AnyRef]): Unit =
//     //   inline erasedValue[Names] match
//     //     case (names: Tuple) =>
//     //       val values = names.map((n: Expr[Any]) => jmap.get(constValue[n].toString))
//     //       val p: T = summonInstance[T].fromProduct(values)
// }
