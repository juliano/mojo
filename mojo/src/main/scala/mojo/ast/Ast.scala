package mojo.ast

import java.{util => ju }

sealed trait Ast {
  val value: AnyRef
}

object Ast {
  case class Leaf(value: AnyRef) extends Ast
  case class Node(value: ju.Map[String, AnyRef]) extends Ast
}