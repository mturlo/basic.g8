name := "$name$"

scalaVersion := "$scala_version$"

libraryDependencies ++= {

  object Versions {
    val scalatest = "3.0.5"
  }

  Seq(

    // prod
    "com.iheart" %% "ficus" % "1.4.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
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
