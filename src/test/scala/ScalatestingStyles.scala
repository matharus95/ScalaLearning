import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.wordspec.AnyWordSpec

object ScalatestingStyles


// First testing suite, FUN SUITES SIMPLEST TESTING STYLE IN SCALA
class CalculatorSuite extends AnyFunSuite {
  val calculatrice = new Calculator

  test("multiplacation by 0 should equal 0 ") {
    assert(calculatrice.multiply(4543,0) == 0)
    assert(calculatrice.multiply(2333, 0) == 0)
  }

  test("dividing by 0 should throw error") {
    assertThrows[ArithmeticException](calculatrice.divide(234,0))
    assertThrows[ArithmeticException](calculatrice.divide(34,0))
  }

}

class CalculatorSpec extends AnyFunSpec {
  val calculatrice = new Calculator

  describe("multiplication") {
    it("should give back 0 if multiplying by zero") {
      assert(calculatrice.multiply(4543, 0) == 0)
      assert(calculatrice.multiply(2333, 0) == 0)
    }
  }

  describe("division") {
    it("Should throw an error if divided by 0 ") {
      assertThrows[ArithmeticException](calculatrice.divide(233,0))
      assertThrows[ArithmeticException](calculatrice.divide(234, 0))
      assertThrows[ArithmeticException](calculatrice.divide(34, 0))
    }
  }
}

class CalculatorWordSpec extends AnyWordSpec {
  val calculatrice = new Calculator

  "A calculator should" should {
    "give back 0 if multiplying by 0" in { //scenario
      assert(calculatrice.multiply(4543, 0) == 0)
      assert(calculatrice.multiply(2333, 0) == 0)
    }
    "throw a math error if divide by 0" in {
      assertThrows[ArithmeticException](calculatrice.divide(233, 0))
      assertThrows[ArithmeticException](calculatrice.divide(234, 0))
      assertThrows[ArithmeticException](calculatrice.divide(34, 0))
    }
  }
}

class CalculatorFreeSpec extends AnyFreeSpec {
  val calculatrice = new Calculator

  "A calculator should" - { // anything you want
    "give back 0 if multiplying by 0" in { //scenario
      assert(calculatrice.multiply(4543, 0) == 0)
      assert(calculatrice.multiply(2333, 0) == 0)
    }
    "throw a math error if divide by 0" in {
      assertThrows[ArithmeticException](calculatrice.divide(233, 0))
      assertThrows[ArithmeticException](calculatrice.divide(234, 0))
      assertThrows[ArithmeticException](calculatrice.divide(34, 0))
    }
  }
}

class CalculatorPropSpec extends AnyPropSpec {
  val calculator = new Calculator
  val multiplyByZero = List((43535,0), (2424,0), (-234,0))

  property("calculator multiply by zero should be 0") {
    assert {
      multiplyByZero.forall { // iterate all the element of the list
        case (a, b) => calculator.multiply(a, b) == 0 // check the case where the function is always equal to 0
      }
    }
  }
}


class Calculator {
  def add(a: Int, b:Int): Int = a + b
  def subtract(a: Int, b:Int): Int = a - b
  def multiply(a: Int, b:Int): Int = a * b
  def divide(a: Int, b:Int): Int = a / b
}
