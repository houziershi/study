class Rational(n: Int, d: Int) { 
	require(d != 0) 

	private val g = gcd(n.abs, d.abs)
	val numer = n / g 
	val denom = d / g 

	def this(n: Int) = this(n, 1)

	def +(that: Rational): Rational = new Rational( 
    numer * that.denom + that.numer * denom, 
    denom * that.denom 
  ) 

  def +(i: Int): Rational = new Rational(numer + i * denom, denom) 

  def -(that: Rational): Rational = new Rational( 
      numer * that.denom - that.numer * denom, 
      denom * that.denom 
    ) 

  def -(i: Int): Rational = new Rational(numer - i* denom, denom) 

  def *(that: Rational): Rational = new Rational(
      numer * that.numer, 
      denom * that.denom
    ) 

  def *(i: Int): Rational = new Rational(numer * i, denom) 

  def /(that: Rational): Rational = new Rational(
     numer * that.denom, 
     denom * that.numer
    ) 

  def /(i: Int): Rational = new Rational(numer, denom * i)

	def lessThan(that: Rational) = 
		this.numer * that.denom < that.numer * this.denom 

	def max(that: Rational) = 
		if (this.lessThan(that)) that else this

	override def toString = n +"/"+ d

	private def gcd(a: Int, b: Int): Int = 
		if (b == 0) a else gcd(b, a % b) 
}

val x = new Rational(2, 3)
print("    x = ");  println(x)
print("x * x = ");  println(x * x)
print("x * 2 = ");  println(x * 2)

implicit def intToRational(x: Int) = new Rational(x)
print("2 * x = ");  println(2 * x)

