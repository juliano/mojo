val scala2Version = "2.13.6"
val scala3Version = "3.0.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "mojo",
    version := "0.1.0",

    llibraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test",

    // To make the default compiler and REPL use Dotty
    scalaVersion := scala3Version,

    // To cross compile with Scala 3 and Scala 2
    crossScalaVersions := Seq(scala3Version, scala2Version)
  )
