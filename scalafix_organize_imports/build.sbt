Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "2.12.12"
ThisBuild / version := "0.1"

ThisBuild / scalafixDependencies ++= Seq(
  "com.github.liancheng" %% "organize-imports" % "0.4.3"
)

ThisBuild / scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xlint:infer-any",
  "-Xlint:missing-interpolator",
  "-Xlint:unsound-match",
  "-Xlint:unused",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible"
)

ThisBuild / semanticdbEnabled := true // enable SemanticDB
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision // use Scalafix compatible version

lazy val core = project
  .in(file("."))
  .settings(
    name := "organize-imports-sample",
    libraryDependencies ++= Seq(
      "org.scalikejdbc" %% "scalikejdbc" % "3.5.0",
    )
  )
