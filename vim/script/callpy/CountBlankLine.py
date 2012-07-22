import vim

count = 0
for line in vim.current.buffer :
	if len(line) == 0:
		count += 1
print "there are " + str(count) + " blank lines in this file"
