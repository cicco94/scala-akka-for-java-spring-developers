package com.academy.controller

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object DummyController extends App {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")

  val route: Route = path("hello") {
    get {
      system.log.info("invoking get")
      complete("Say hello to akka-http")
    }
  }

  Http().newServerAt("localhost", 8080).bind(route)
}
