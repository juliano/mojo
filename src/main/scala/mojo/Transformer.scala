// package mojo

// import scala.compiletime.{ constValue, erasedValue, summonInline }
// import scala.deriving.Mirror
// import scala.jdk.CollectionConverters._

// import java.util as ju

// object Transformer {

//   enum Ast:
//     def value: AnyRef
//     case Leaf(value: AnyRef) extends Ast //aaa
//     case Node(value: ju.Map[String, AnyRef]) extends Ast

//   inline given toJavaDerived[T]: JavaEncoder[T] = JavaEncoder.derived

//   object ToJavaOps:
//     extension [T](value: T)(using tj: JavaEncoder[T])
//       def toJMap: ju.Map[String, AnyRef] =
//         tj.toJMap(value) match
//           case Ast.Node(map) => map
//           case _ => throw new IllegalArgumentException("Not a product type")

//   import scala.quoted._
//   object PrintMacPass {
//     inline def apply[T](inline any: T): T = ${ printMacImpl('any) }
//     def printMacImpl[T: Type](any: Expr[T])(using qctx: Quotes): Expr[T] = {
//         import qctx.reflect._
//         println(Printer.TreeShortCode.show(any.asTerm))
//         any
//     }
//   }

//   trait JavaEncoder[T]:
//     def toJMap(value: T): Ast

//   object JavaEncoder:
//     inline def summonInstance[T]: JavaEncoder[T] = summonInline[JavaEncoder[T]]

//     given byte: JavaEncoder[Byte] with
//       def toJMap(value: Byte) = Ast.Leaf(Byte.box(value))

//     given short: JavaEncoder[Short] with
//       def toJMap(value: Short) = Ast.Leaf(Short.box(value))

//     given integer: JavaEncoder[Int] with
//       def toJMap(value: Int) = Ast.Leaf(Int.box(value))

//     given long: JavaEncoder[Long] with
//       def toJMap(value: Long) = Ast.Leaf(Long.box(value))

//     given float: JavaEncoder[Float] with
//       def toJMap(value: Float) = Ast.Leaf(Float.box(value))

//     given double: JavaEncoder[Double] with
//       def toJMap(value: Double) = Ast.Leaf(Double.box(value))

//     given char: JavaEncoder[Char] with
//       def toJMap(value: Char) = Ast.Leaf(Char.box(value))

//     given boolean: JavaEncoder[Boolean] with
//       def toJMap(value: Boolean) = Ast.Leaf(Boolean.box(value))

//     given string: JavaEncoder[String] with
//       def toJMap(value: String) = Ast.Leaf(value)

//     given option[T](using tj: JavaEncoder[T]): JavaEncoder[Option[T]] with
//       def toJMap(opt: Option[T]) = Ast.Leaf(opt.map(tj.toJMap(_).value).orNull)

//     given list[T](using tj: JavaEncoder[T]): JavaEncoder[List[T]] with
//       def toJMap(list: List[T]) = Ast.Leaf(list.map(tj.toJMap(_).value).asJava)

//     inline def derived[T]: JavaEncoder[T] =
//       inline summonInline[Mirror.Of[T]] match
//         case prod: Mirror.ProductOf[T] =>
//           PrintMacPass(
//           new JavaEncoder[T]:
//             def toJMap(value: T): Ast =
//               Ast.Node(recurse[prod.MirroredElemLabels, prod.MirroredElemTypes](value.asInstanceOf[Product])(0).asJava))
//         case sum: Mirror.SumOf[T] =>
//           PrintMacPass(
//           new JavaEncoder[T]:
//             def toJMap(value: T): Ast =
//               recurseSum[sum.MirroredElemTypes, T](value))
//         case _ => throw new IllegalArgumentException(s"Mirror not found")

//     inline def recurse[Names <: Tuple, Types <: Tuple](element: Product)(index: Int): Map[String, AnyRef] =
//       inline erasedValue[(Names, Types)] match
//         case (_: (name *: names), _: (tpe *: types)) =>
//           val key = constValue[name].toString
//           val value = element.productElement(index).asInstanceOf[tpe]
//           val transformed = summonInstance[tpe].toJMap(value).value
//           recurse[names, types](element)(index + 1) + (key -> transformed)
//         case (_: EmptyTuple, _) =>
//           Map.empty[String, AnyRef]

//     inline def recurseSum[Types <: Tuple, T](element: T): Ast =
//       inline erasedValue[Types] match
//         case _: (tpe *: types) =>
//           if (element.isInstanceOf[tpe])
//             summonInstance[tpe].toJMap(element.asInstanceOf[tpe])
//           else
//             recurseSum[types, T](element)
//         case _: EmptyTuple =>
//           throw new IllegalArgumentException(s"Invalid coproduct type")
// }
