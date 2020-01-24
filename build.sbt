name := "monad-tutorial"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "1.0.0-RC17",
  "com.softwaremill.sttp.client" %% "core" % "2.0.0-RC3",
  "com.softwaremill.sttp.client" %% "async-http-client-backend-zio" % "2.0.0-RC4",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
