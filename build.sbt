name := "scala-akka-for-java-spring-developers"

version := "0.1"

scalaVersion := "2.13.5"

val akkaVersion = "2.6.14"

val akkaHttpVersion = "10.2.4"

val slickVersion = "3.3.3"

val scalaTestVersion = "3.1.2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion

libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpVersion

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % akkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test

libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.23"

libraryDependencies += "com.typesafe.slick" %% "slick" % slickVersion

libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % slickVersion

libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "2.0.2"

libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % Test
