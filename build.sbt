name := "scala-akka-for-java-spring-developers"

version := "0.1"

scalaVersion := "2.13.5"

val AkkaVersion = "2.6.14"

val AkkaHttpVersion = "10.2.4"

val SlickVersion = "3.3.3"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion

libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion

libraryDependencies += "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.23"

libraryDependencies += "com.typesafe.slick" %% "slick" % SlickVersion

libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % SlickVersion

libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "2.0.2"