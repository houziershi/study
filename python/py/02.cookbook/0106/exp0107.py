# encode=utf-8

str = '0123456789'
print str[::-1]

str = 'Hello world\n Hi\tPython'
tmp = str.split()
tmp.reverse()
tmp = ' '.join(tmp)
print tmp

tmp = ' '.join(str.split()[::-1])
print tmp

import re
tmp = re.split(r'(\s+)', str)
tmp.reverse()
tmp = ' '.join(tmp)
print tmp

tmp = ' '.join(re.split(r'(\s+)',str)[::-1])
print tmp
