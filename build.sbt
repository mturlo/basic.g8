name := "$name$"

scalaVersion := "$scala_version$"

libraryDependencies ++= {

  object Versions {
    val scalatest = "3.0.0"
  }

  Seq(

    // prod
    "com.iheart" %% "ficus" % "1.4.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3",

    // test
    "org.scalatest" %% "scalatest" % Versions.scalatest % "test"

  ).map(_ withSources() withJavadoc())

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
