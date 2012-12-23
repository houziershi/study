if($line =~ m/^Subject: (.*)/i) {
	$subject = $1;
}

# From: elvis@tabloid.org (The King)
if($line =~ m/^From: (\S+) \(([^()]*)\)/i) {
	$reply_address = $1;
	$from_name = $2;
}



$line =~ s/^/|> /;
print $line





