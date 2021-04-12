package com.academy.service

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import com.academy.model.User
import com.academy.table.UserTable.UserTable
import com.academy.table.UserTable.session.db
import slick.dbio.DBIO

import scala.concurrent.{ExecutionContextExecutor, Future}
import slick.driver.MySQLDriver.api._

object UserService {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "SprayExample")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  def createDb(): Unit = {
    db.run(DBIO.seq(
      sqlu"""drop table IF EXISTS suppliers """,
      sqlu"""create table suppliers(id int primary key, name varchar(16) not null) """
    ))
  }

  def insertOne(user: User): Unit = {
    db.run(TableQuery[UserTable] += (user.id, user.name))
  }

  def findAll(): Future[Seq[(Int, String)]] = {
    db.run(TableQuery[UserTable].result)
  }

}
