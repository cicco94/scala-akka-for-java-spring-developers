package com.academy.service

import com.academy.model.{Item, Order}
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class OrderServiceTest extends AnyFlatSpec with Matchers {

  "Orders" should "be empty" in {
    OrderService.orders should equal(Nil)
  }

  "Orders" should "be populated" in {
    OrderService.orders should equal(Nil)
    OrderService.saveOrder(Order(List()))
    OrderService.orders should equal(Nil)
    OrderService.saveOrder(Order(List(Item("name", 1))))
    OrderService.orders should have size(1)
    OrderService.orders should equal(List(Item("name", 1)))
  }

}
