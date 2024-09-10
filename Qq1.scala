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

  override def toString: String = s"$finalNumerator/$finalDenominator"
}

object GreatestCommonDivisor {
  def apply(a: Int, b: Int): Int = gcd(a, b)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object Main extends App {

  print("Enter the numerator for rational 3 : ")
  val z_n = scala.io.StdIn.readInt()

  print("Enter the denominator for rational 3 : ")
  val z_d = scala.io.StdIn.readInt()

  val z = new Rational(z_n, z_d)

  println(s"Original: "+z)       
  println(s"Negated: "+z.neg)  

}