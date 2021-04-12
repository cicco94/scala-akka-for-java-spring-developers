package com.academy.controller

import akka.Done
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{as, complete, entity, onSuccess, path, post}
import com.academy.model.{Item, Order}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Route
import com.academy.service.OrderService.saveOrder
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

import scala.concurrent.{ExecutionContextExecutor, Future}

object MarshalledController extends App {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  implicit val itemFormat: RootJsonFormat[Item] = jsonFormat2(Item)
  implicit val orderFormat: RootJsonFormat[Order] = jsonFormat1(Order)

  // POST localhost:8080/order => {"items":[{"name":"n1", "id":1}]}
  val route: Route = path("order") {
    post {
      system.log.info("invoking post")
      entity(as[Order]) { order =>
        val saved: Future[List[Item]] = saveOrder(order)
        onSuccess(saved) { _ =>
          complete(saved)
        }
      }
    }
  }

  Http().newServerAt("localhost", 8080).bind(route)
}
