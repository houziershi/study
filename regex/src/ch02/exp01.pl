$/ = ".\n";
	while (<>) {
		next if !s/\b([a-z]+)((?:\s|<[^>]+>)+)(\1\b)/\e[7m$1\e[m$2\e[7m$3\e[m/ig;
		s/^(?:[^s\e]*\n)+//mg;	# remove the unmarked line
		s/^/$ARGV: /mg;			# add filename before the line
		print;
	}
