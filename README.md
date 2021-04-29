# Scala Akka Slick demo
We will follow this common pattern: Controller -> Service -> Repository -> Service -> Controller

### Run the environment
- run the following tasks: `sbt clean`, `sbt compile`
- run the docker here `docker/docker-run.sh`
- run any the controller

### Controllers
- `src/main/scala/com/academy/controller/DummyController.scala`: just a hello-world test at localhost:8080
- `src/main/scala/com/academy/controller/MarshalledController.scala`: get confidence with the scala json [un]marshalling here
- `src/main/scala/com/academy/controller/UserController.scala`: get confidence with the database integration here

### Configurations
- `src/main/resources/application.conf`: it configures the logger
- `src/main/resources/logback.xml`: it configures the logger
- `src/main/resources/mysql-application.conf`: it configures the database

### Unit tests 
To start, follow this samples:
- `src/test/scala/com/academy/DummySpec.scala`
- `src/test/scala/com/academy/service/OrderServiceSpec.scala`
Then, take a look to how test a controller here:
- `src/test/scala/com/academy/controller/UserControllerSpec.scala`

#### External resources:
- akka official doc: https://doc.akka.io/docs/akka/current/index.html?language=scala
- akka json doc: https://doc.akka.io/docs/akka-http/current/common/json-support.html
- scala test doc: https://www.baeldung.com/scala/scalatest#:~:text=ScalaTest%20is%20one%20of%20the,BDD%20out%20of%20the%20box.

#### Author:
ciccottandrea@gmail.com
