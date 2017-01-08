name := "$name$"

version := "0.1.0-SNAPSHOT"

scalaVersion := "$scala_version$"

libraryDependencies ++= {

  object Versions {
    val scalatest = "3.0.0"
  }

  Seq(
    "org.scalatest" %% "scalatest" % Versions.scalatest % "test"
  )

}

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings",
  "-language:postfixOps"
)

lazy val root = project in file(".")

// scalastyle check on compile

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

(compile in Compile) <<= (compile in Compile) dependsOn compileScalastyle
