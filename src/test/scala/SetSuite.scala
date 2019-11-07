import org.scalatest.FunSuite

class SetSuite extends FunSuite {

  val dict1: Map[Int, String] = Map(3 -> "Foo", 5 -> "Bar", 7 -> "Qix")

  val dict2: Map[Int, String] = Map(0 -> "*", 3 -> "Foo", 5 -> "Bar", 7 -> "Qix")

  def convert(value: Int): String = {

    val divisiblePart: List[String] = dict1.keys
      .filter(isDivisibleBy(value, _))
    .flatMap(dict1.get).toList

    val digits: Array[Int] = value.toString.toCharArray.map(_.asDigit)


    val digitPart: Array[String] = if ( divisiblePart.isEmpty && !digits.exists(dict1.contains)){

      digits.map(c => dict2.getOrElse(c, c.toString))

    } else {

      digits.map(dict2.getOrElse(_, ""))

    }

    val t = (divisiblePart ++ digitPart).mkString("")

    if(t == ""){
      value.toString
    } else {
      t
    }

  }

  private def isDivisibleBy(value: Int, a: Int) = {
    value % a == 0
  }

  test("Normal case") {
    assert(convert(1) == "1")
  }

  test("Should return Foo when divisible by 3") {
    assert(convert(6) == "Foo")
  }

  test("Should return Bar* when divisible by 5") {
    assert(convert(10) == "Bar*")
  }

  test("Should return Qix when divisible by 7") {
    assert(convert(14) == "Qix")
  }

  test("Should return FooFoo when 3") {
    assert(convert(3) == "FooFoo")
  }

  test("Should return FooBarQix when 63571") {
    assert(convert(63571) == "FooBarQix")
  }

  test("Should return FooBarBar when 15") {
    assert(convert(15) == "FooBarBar")
  }

  test("Should return 1*1 when 101") {
    assert(convert(101) == "1*1")
  }
}