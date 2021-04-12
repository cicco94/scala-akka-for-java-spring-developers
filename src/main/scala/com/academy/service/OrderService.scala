package com.academy.service

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import com.academy.model.{Item, Order}

import scala.concurrent.{ExecutionContextExecutor, Future, Promise}

object OrderService {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  var orders: List[Item] = Nil

  def saveOrder(order: Order): Future[List[Item]] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _            => orders
    }
    Promise.successful(orders).future
  }
}
