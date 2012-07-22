" count blank lines in buffer

function! CountBlankLine()
python << EOF
import vim
count = 0
for line in vim.current.buffer :
	if len(line) == 0:
		count += 1
print "there are " + str(count) + " blank lines in this file"
EOF
endfunction

map <f7> :call CountBlankLine() <cr>
