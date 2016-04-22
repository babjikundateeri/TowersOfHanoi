import sbt._
import Process._
import Keys._

// logback for logging
val logback = "ch.qos.logback" %  "logback-classic" % "1.1.7"

// junit dependecy
val junit = "com.novocode" % "junit-interface" % "0.11" % "test"

// scalatest dependecy
val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"


lazy val commonSettings = Seq (
    name := "ScalaTowersOfHanoi",
    scalaVersion := "2.11.8",
    version := "0.1.0",
    organization := "com.pramati.scala"
)

lazy val depedencySettings = Seq (
	libraryDependencies += logback,
	libraryDependencies += scalatest,
	libraryDependencies += junit
)

lazy val testOptionSettings = Seq (
	testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),  // junit test options 
	testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oSD")   // scalatest options
)

lazy val root = (project in file(".")).
  settings(commonSettings:_*).
  settings(depedencySettings:_*).
  settings(testOptionSettings:_*)    
