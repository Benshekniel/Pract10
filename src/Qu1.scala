object RationalApp {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be non-zero")

    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    override def toString: String = s"$numer/$denom"

    def neg: Rational = new Rational(-numer, denom)

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    println(s"Rational number x: $x")
    println(s"Negation of x: ${x.neg}")
  }
}
