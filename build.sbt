import BuildHelper._

inThisBuild(
  List(
    organization := "io.github.juliano",
    homepage := Some(url("https://github.com/juliano/mojo")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "juliano",
        "Juliano Alves",
        "von.juliano@gmail.com",
        url("https://juliano-alves.com/")
      )
    )
  )
)

lazy val root = project
  .in(file("."))
  .settings(
    publish / skip := true
  )
  .aggregate(
    mojo
  )

lazy val mojo = project
  .in(file("mojo"))
  .settings(stdSettings("mojo"))
  .settings(buildInfoSettings("mojo"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9",
      "org.scalatestplus" %% "scalacheck-1-15" % "3.2.9.0"
    )
  )