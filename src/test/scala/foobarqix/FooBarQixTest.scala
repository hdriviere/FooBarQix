package foobarqix

import org.scalatest.FunSuite

class FooBarQixTest extends FunSuite {
  test("Normal case") {
    assert(FooBarQix.compute(1) == "1")
  }

  test("Should return Foo when divisible by 3") {
    assert(FooBarQix.compute(6) == "Foo")
  }

  test("Should return Bar when divisible by 5") {
    assert(FooBarQix.compute(10) == "Bar*")
  }

  test("Should return Qix when divisible by 7") {
    assert(FooBarQix.compute(14) == "Qix")
  }

  test("Should return FooFoo when 3") {
    assert(FooBarQix.compute(3) == "FooFoo")
  }

  test("Should return FooBarQix when 63571") {
    assert(FooBarQix.compute(63571) == "FooBarQix")
  }

  test("Should return FooBarBar when 15") {
    assert(FooBarQix.compute(15) == "FooBarBar")
  }

  test("Should return 1*1 when 101") {
    assert(FooBarQix.compute(101) == "1*1")
  }
}
