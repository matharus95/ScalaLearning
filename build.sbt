ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

val scalatestVersion = "3.2.15"
lazy val root = (project in file("."))
  .settings(
    name := "ScalaTest"
  )
libraryDependencies ++= Seq(
  // testing
  "org.scalactic" %% "scalactic" % scalatestVersion,
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
)