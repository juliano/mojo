// package mojo

// import org.scalatest.freespec.AnyFreeSpec
// import org.scalatest.matchers.must.Matchers
// import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

// import java.util as ju
// import scala.jdk.CollectionConverters._

// import Transformer.ToJavaOps.toJMap

// class ToJavaSpec extends AnyFreeSpec with Matchers with ScalaCheckPropertyChecks:
//   case class AllPrimitives(
//       by: Byte,
//       s: Short,
//       i: Int,
//       l: Long,
//       f: Float,
//       d: Double,
//       c: Char,
//       b: Boolean
//   )

//   // "transforms all primitive fields" in {
//   //   forAll { (by: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, c: Char, b: Boolean) =>
//   //     val all                          = AllPrimitives(by, s, i, l, f, d, c, b)
//   //     val jmap: ju.Map[String, AnyRef] = all.toJMap

//   //     jmap.get("by") mustBe a[java.lang.Byte]
//   //     jmap.get("s") mustBe a[java.lang.Short]
//   //     jmap.get("i") mustBe a[java.lang.Integer]
//   //     jmap.get("l") mustBe a[java.lang.Long]
//   //     jmap.get("f") mustBe a[java.lang.Float]
//   //     jmap.get("d") mustBe a[java.lang.Double]
//   //     jmap.get("c") mustBe a[java.lang.Character]
//   //     jmap.get("b") mustBe a[java.lang.Boolean]
//   //   }
//   // }

//   "case class" in {
//     case class Test(i: Int, i2: Long)

//     forAll { (i: Int) =>
//       val jmap = Test(i, i).toJMap
//       jmap.get("i") mustEqual i
//     }
//   }

//   // "options" in {
//   //   case class TestOpt(o: Option[Int])

//   //   forAll { (o: Option[Int]) =>
//   //     val jmap = TestOpt(o).toJMap
//   //     if (o.isEmpty)
//   //       jmap.get("o") mustEqual null
//   //     else
//   //       jmap.get("o") mustEqual o.get
//   //   }
//   // }

//   // "lists" in {
//   //   case class TestList(l1: List[String], l2: List[Double])

//   //   forAll { (l1: List[String], l2: List[Double]) =>
//   //     val jmap = TestList(l1, l2).toJMap
//   //     jmap.get("l1") mustEqual l1.asJava
//   //     jmap.get("l2") mustEqual l2.asJava
//   //   }
//   // }
