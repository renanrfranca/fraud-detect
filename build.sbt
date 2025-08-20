name := "fraud-detect"
organization := "io.github.renanrfranca"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(scalacOptions += "-Wunused:imports")

scalaVersion := "3.3.4"
semanticdbEnabled := true // enable SemanticDB
semanticdbVersion := scalafixSemanticdb.revision

val PekkoVersion = "1.1.5"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test,
  "org.playframework" %% "play-json" % "3.0.5",
  "org.apache.pekko" %% "pekko-connectors-kafka" % "1.1.0",
  "org.apache.pekko" %% "pekko-stream" % PekkoVersion,
  "org.apache.pekko" %% "pekko-actor-typed" % PekkoVersion,
  "org.apache.pekko" %% "pekko-serialization-jackson" % PekkoVersion,
  "org.apache.pekko" %% "pekko-slf4j" % PekkoVersion,
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
