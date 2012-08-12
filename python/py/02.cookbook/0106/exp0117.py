# coding=utf-8

import string

tmp = string.Template('Value is $value')
print tmp.substitute({'value':5})
print tmp.substitute({'value':'default'})
print tmp.substitute(value=5)
print tmp.substitute(value='default')

''' use $$ to show $ '''
tmp = string.Template('The cost is $$ $value')
print tmp.substitute(value=5)
