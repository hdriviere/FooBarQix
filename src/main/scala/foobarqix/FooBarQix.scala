package foobarqix

object FooBarQix {
  def isDivisibleBy(value: Int, divisor: Int): Boolean = { value % divisor == 0 }

  def containsValue(value: Int, dict: Map[Int, String]): Boolean = { value.toString.map((c: Char) => c.asDigit).exists(dict.contains) }

  def compute(value: Int): String = {
    val dict: Map[Int, String] = Map(3 -> "Foo", 5 -> "Bar", 7 -> "Qix")

    val divisiblePart: List[String] = dict.keys
      .filter(isDivisibleBy(value, _))
      .flatMap(dict.get)
      .toList

    val digits = value.toString.map((c: Char) => c.asDigit)

    val digitsPart: List[String] = if(!containsValue(value, dict) && divisiblePart.isEmpty){
      digits.map {
          case 0 => "*"
          case c => c.toString
        }
        .toList
    } else {
      digits.map {
          case 0 => "*"
          case c => dict.getOrElse(c, "")
        }
        .toList
    }

    divisiblePart.mkString("") + digitsPart.mkString("")
  }

  def main(args:Array[String]){
    LazyList.from(1).map(compute).take(200).foreach(println)
  }
}
