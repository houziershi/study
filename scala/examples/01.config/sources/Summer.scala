import ChecksumAccumulator.calculate

object Summer {

	def main(args: Array[String]) {
		if(args.length == 0)
			println("No argument input... ")
		for (arg <- args)
			println(arg + " -> " + calculate(arg))
	}

}
