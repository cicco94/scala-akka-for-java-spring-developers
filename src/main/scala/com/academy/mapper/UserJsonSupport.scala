package com.academy.mapper

import com.academy.model.User

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object UserJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User)
}
