print "Enter a temperature in Celsius: \n";

$celsius = <STDIN>;
# remove \n at end of line
chomp($celsius);

if($celsius =~ m/^[+-]?[0-9]+(\.[0-9]*)?$/) {
	$fahrenheit = ($celsius*9/5)+32;
	# format output use printf
	printf "%.2f C is %.2f F.\n", $celsius, $fahrenheit ;
} else {
	print "Expecting a number, don't understane \"$celsius\".\n";
}
