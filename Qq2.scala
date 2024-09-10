import scala.math

class Rational(numerator: Int, denominator: Int) {
  require(denominator != 0, "Denominator cannot be zero.")

  private val gcd = GreatestCommonDivisor(numerator, denominator)
  private val normalizedNumerator = numerator / gcd
  private val normalizedDenominator = denominator / gcd

  val (finalNumerator, finalDenominator) =
    if (normalizedDenominator < 0) (-normalizedNumerator, -normalizedDenominator)
    else (normalizedNumerator, normalizedDenominator)

  def neg: Rational = new Rational(-finalNumerator, finalDenominator)

  def sub(other: Rational): Rational = {
    val commonDenominator = finalDenominator * other.finalDenominator
    val newNumerator = (finalNumerator * other.finalDenominator) - (other.finalNumerator * finalDenominator)
    new Rational(newNumerator, commonDenominator)
  }

  override def toString: String = s"$finalNumerator/$finalDenominator"
}

object GreatestCommonDivisor {
  def apply(a: Int, b: Int): Int = gcd(a, b)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object Main extends App {
  

  print("Enter the numerator for rational 1 : ")
  val x_n = scala.io.StdIn.readInt()

  print("Enter the denominator for rational 1 : ")
  val x_d = scala.io.StdIn.readInt()
  
  val x = new Rational(x_n, x_d)


  print("Enter the numerator for rational 2 : ")
  val y_n = scala.io.StdIn.readInt()

  print("Enter the denominator for rational 2 : ")
  val y_d = scala.io.StdIn.readInt()

  val y = new Rational(y_n, y_d)

  print("Enter the numerator for rational 3 : ")
  val z_n = scala.io.StdIn.readInt()

  print("Enter the denominator for rational 3 : ")
  val z_d = scala.io.StdIn.readInt()

  val z = new Rational(z_n, z_d)

  val y_z = y.sub(z)
  val result = x.sub(y_z)

  println(s"x = "+x)            
  println(s"y = "+y)            
  println(s"z = "+z)            
  println(s"y - z = "+y_z)  
  println(s"x - (y - z) = "+result) 
}