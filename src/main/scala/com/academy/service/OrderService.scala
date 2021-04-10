package com.academy.service

import akka.Done
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import com.academy.model.{Item, Order}

import scala.concurrent.{ExecutionContextExecutor, Future}

object OrderService {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  var orders: List[Item] = Nil

  def saveOrder(order: Order): Future[Done] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _            => orders
    }
    Future { Done }
  }
}
