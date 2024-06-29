val scala3Version = "3.4.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "mimicEvent",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R24",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
