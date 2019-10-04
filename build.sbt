name := "$name$"

scalaVersion := "$scala_version$"

libraryDependencies ++= {

  object Versions {
    val scalatest = "3.0.8"
  }

  Seq(

    // prod
    "com.iheart" %% "ficus" % "1.4.7",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
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
turbo := true
