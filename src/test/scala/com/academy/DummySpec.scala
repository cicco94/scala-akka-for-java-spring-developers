package com.academy

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DummySpec extends AnyFlatSpec with Matchers {

  "With a matcher" should "let us check equality" in {
    val number = 25
    number should equal(25)
    number shouldEqual 25
  }

}
