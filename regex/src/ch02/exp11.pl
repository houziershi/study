while($line = <>) {
	# ... deal with $line ...
	if($line =~ m/^\s*$/) {
		last; # jump out of loop
	}
}

$text =~ s/^$/<p>/mg;

$text =~ s{
	\b
	# save email address to variable
	{
		username-regex
		\@
		hostname-regex
	}
	\b
}{<a href="mailto$1">$1</a>}gix

$tmpRegex = qr/china/i;

$text =~ s{
	$tmpRegex
}{CHINA}gix
