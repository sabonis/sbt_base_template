lazy val root = (project in file("."))
  .enablePlugins(SbtWeb)
  .settings(
    name := "hello",
    version := "1.0",
    scalaVersion := "2.11.8",
    unmanagedResourceDirectories in Compile += baseDirectory.value / "target/web/public/main"
  )

libraryDependencies +=
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.3"

