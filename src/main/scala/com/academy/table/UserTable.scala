package com.academy.table

import akka.stream.alpakka.slick.javadsl.SlickSession

object UserTable {
  implicit val session: SlickSession = SlickSession.forConfig("slick")

  // This import brings everything you need into scope
  import session.profile.api._

  // The example domain
  case class UserTable(tag: Tag) extends Table[(Int, String)](tag, "suppliers") {
    def id = column[Int]("ID")

    def name = column[String]("NAME")

    def * = (id, name)
  }

}
