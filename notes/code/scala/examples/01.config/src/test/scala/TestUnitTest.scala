package com.tysonhamilton.scalatest.test

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class TestUnitTest extends FunSuite {

	test("TwoPlusTwo") {
		val twoPlusTwo = 2 + 2
		assert(twoPlusTwo == 4)
	}

}
