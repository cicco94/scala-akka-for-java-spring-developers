package com.academy.controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.MessageEntity
import akka.http.scaladsl.server.Directives.{as, complete, entity, get, path, post}
import akka.http.scaladsl.server.{Directives, Route}
import com.academy.model.User
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture

import scala.concurrent.Future

class UserControllerSpec extends AnyFlatSpec with Matchers with ScalatestRouteTest {

  object UserJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
    implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User)
  }

  def findAll(): Future[Seq[(Int, String)]] = {
    Future{Seq()}
  }

  val smallRoute: Route = path("user") {
    import com.academy.mapper.UserJsonSupport._
    Directives.concat(
      post {
        entity(as[User]) { _ => complete("user created")}
      },

      get {
        system.log.info("invoking get")
        complete(findAll())
      }

    )
  }

  "User controller" should "be receive GET & POST requests properly" in {
    import com.academy.mapper.UserJsonSupport._
    Get("/user") ~> smallRoute ~> check {
      status should be (OK)
      entityAs[Seq[User]] should be (Seq())
    }

    val user = User(1994, "Andrea")
    val userEntity = Marshal(user).to[MessageEntity].futureValue
    val postRequest = Post("/user").withEntity(userEntity)
    postRequest ~> smallRoute ~> check {
      status should be (OK)
      entityAs[String] should be ("user created")
    }

  }
}
