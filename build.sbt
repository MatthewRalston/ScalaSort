name := "mergesort"

organization := "MatthewRalston"

version := "0.0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
  "com.github.scopt" %% "scopt" % "3.3.0",
  "org.scala-sbt" % "sbt" % "0.13.0",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
)

initialCommands := "import MatthewRalston.mergesort._"

