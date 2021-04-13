package com.academy.controller

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{as, complete, entity, get, onSuccess, path, post}
import akka.http.scaladsl.server.{Directives, Route}
import com.academy.model.User
import com.academy.service.UserService

import scala.concurrent.{ExecutionContextExecutor, Future}

object UserController extends App {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  UserService.createDb()

  val userControllerRoute: Route = path("user") {
    import com.academy.mapper.UserJsonSupport._
    Directives.concat(

      post {
        system.log.info("invoking post")
        entity(as[User]) { user =>
          val saved = Future.successful(user)
          onSuccess(saved) { _ =>
            UserService.insertOne(user)
            complete("user created")
          }
        }
      },

      get {
        system.log.info("invoking get")
        complete(UserService.findAll())
      }

    )
  }

  Http().newServerAt("localhost", 8080).bind(userControllerRoute)
}
