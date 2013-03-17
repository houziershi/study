import scala.collection.mutable.Map

class ChecksumAccumulator {
	private var sum = 0
	def add(b: Byte) { sum += b }
	def checksum(): Int =  ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
	private val cache = Map[String, Int]()

	def caculate(s: String): Int = {
		if (cache.contains(s))
			cache(s)
		else {
			val acc = new ChecksumAccumulator
			for (c <- s)
				acc.add(c.toByte)
			val cs = acc.checksum()
			cache += (s -> cs)
			cs
		}
	}
}

val res1 = ChecksumAccumulator.caculate("Every value is an object")
println(res1)

val res2 = ChecksumAccumulator.caculate("So simple!")
println(res2)
