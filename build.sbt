organization := "net.andimiller"
name := "natchez-opentelemetry"

version := "0.0.1"
isSnapshot := true

scalaVersion := "2.13.6"

val otelVersion = "1.4.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= List(
  "io.opentelemetry" % "opentelemetry-api" % otelVersion,
  "io.opentelemetry" % "opentelemetry-sdk" % otelVersion,
  "org.tpolecat" %% "natchez-core" % "0.0.26",
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.4.4",
)

addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.0" cross CrossVersion.full)

import xerial.sbt.Sonatype._

useGpg := true
publishTo := sonatypePublishTo.value
licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))
sonatypeProjectHosting := Some(GitHubHosting("andimiller", "natchez-opentelemetry", "andi at andimiller dot net"))
developers := List(Developer(id = "andimiller", name = "Andi Miller", email = "andi@andimiller.net", url = url("http://andimiller.net")))