if("-111.222F" =~ m/^([+-]?[0-9]+(\.[0-9]*)?)([CF])$/) {
	print "$1\n";	# -111.222
	print "$2\n";	# .222
	print "$3\n";	# F
}
