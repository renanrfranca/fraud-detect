name := "fraud-detect"
organization := "io.github.renanrfranca"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(scalacOptions += "-Wunused:imports")

scalaVersion := "3.3.4"
semanticdbEnabled := true // enable SemanticDB
semanticdbVersion := scalafixSemanticdb.revision

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
