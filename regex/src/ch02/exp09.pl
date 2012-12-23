print "Enter a temperature in input(e.g. 32.5F, 10.0C): \n";

$input = <STDIN>;
chomp($input); # remove \n at end of line

if($input =~ m/^([+-]?[0-9]+(\.[0-9]*)?)\s*([CF])$/i) {
	$number = $1;
	$type = $3;
	if($type =~ m/c/i){
		$celsius = $number;
		$fahrenheit = ($input*9/5)+32;
	} else {
		$fahrenheit = $number;
		$celsius = ($input-32)*5/9;
	}
	printf "%.2f C is %.2f F.\n", $celsius, $fahrenheit ;
} else {
	print "Expecting a number, don't understane \"$input\".\n";
}
