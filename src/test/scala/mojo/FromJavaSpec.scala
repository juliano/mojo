// package mojo

// import org.scalatest.freespec.AnyFreeSpec
// import org.scalatest.matchers.must.Matchers
// import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

// import java.util as ju

// import From.JavaDecoder._

// class FromJavaSpec extends AnyFreeSpec with Matchers with ScalaCheckPropertyChecks:
//   case class Oba(eita: String)
//   val jmap = new ju.HashMap[String, AnyRef]()
//   jmap.put("eita", "opa")

//   // "first attempt" in {
//   //   From.decode[Oba](jmap) mustEqual Oba("opa")
//   // }
