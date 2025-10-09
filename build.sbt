name := "fraud-detect"
organization := "io.github.renanrfranca"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(scalacOptions += "-Wunused:imports")

scalaVersion := "3.7.2"
semanticdbEnabled := true
semanticdbVersion := scalafixSemanticdb.revision

val PekkoVersion = "1.1.5"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test, // Play 3.0.0 / ScalaTest 3.2.x
  "org.playframework" %% "play-json" % "3.0.5",
  "org.apache.pekko" %% "pekko-connectors-kafka" % "1.1.0",
  "org.apache.pekko" %% "pekko-stream" % PekkoVersion,
  "org.apache.pekko" %% "pekko-actor-typed" % PekkoVersion,
  "org.apache.pekko" %% "pekko-serialization-jackson" % PekkoVersion,
  "org.apache.pekko" %% "pekko-slf4j" % PekkoVersion,
  "ch.qos.logback" % "logback-classic" % "1.5.18",
  "org.reactivemongo" %% "play2-reactivemongo" % "1.1.0-play30.RC17"
)