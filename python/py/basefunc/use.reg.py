# coding=utf-8

import re

match = re.match('Hello[ \t]*(.*)world','Hello	Python world')
print match.group(1)                          #  match 'Python'

match = re.match('/(.*)/(.*)/(.*)', '/usr/home/lumberjack')
print match.groups()         # ('usr', 'home', 'lumberjack') 
print len(match.groups())    # 3
print match.group(1)         # 'usr'
print match.groups()[0]      # 'usr'

