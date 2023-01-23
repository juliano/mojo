package mojo

import mojo.ast.Ast

trait JMapEncoder[A] {
  def encode(value: A): Ast
}

object JMapEncoder {
  def apply[A](implicit e: JMapEncoder[A]): JMapEncoder[A] = e

  implicit val byte: JMapEncoder[Byte]       = (value: Byte) => Ast.Leaf(Byte.box(value))
  implicit val short: JMapEncoder[Short]     = (value: Short) => Ast.Leaf(Short.box(value))
  implicit val int: JMapEncoder[Int]         = (value: Int) => Ast.Leaf(Int.box(value))
  implicit val long: JMapEncoder[Long]       = (value: Long) => Ast.Leaf(Long.box(value))
  implicit val float: JMapEncoder[Float]     = (value: Float) => Ast.Leaf(Float.box(value))
  implicit val double: JMapEncoder[Double]   = (value: Double) => Ast.Leaf(Double.box(value))
  implicit val char: JMapEncoder[Char]       = (value: Char) => Ast.Leaf(Char.box(value))
  implicit val boolean: JMapEncoder[Boolean] = (value: Boolean) => Ast.Leaf(Boolean.box(value))
  implicit val string: JMapEncoder[String]   = (value: String) => Ast.Leaf(value)

  implicit def option[A](implicit e: JMapEncoder[A]): JMapEncoder[Option[A]] = (opt: Option[A]) =>
    Ast.Leaf(opt.map(e.encode(_).value).orNull)
}
