lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.dokodeglobal",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "stalker",
    libraryDependencies ++= Seq(
      "org.twitter4j" % "twitter4j-core" % "4.0.4"
        , "org.twitter4j" % "twitter4j-stream" % "4.0.4"
    )
  )
