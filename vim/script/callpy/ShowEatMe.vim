" show message in the state bar

function! ShowEatMe()

python << EOF
print 'EAT ME'
EOF
endfunction

map <f7> :call ShowEatMe() <cr>
