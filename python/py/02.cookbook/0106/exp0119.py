# encode=utf-8

import itertools

def anyTrue(predicate, sequence):
	return True in itertools.imap(predicate, sequence)

def endsWith(s, *endings):
	return anyTrue(s.endswith, endings)

import os

for filename in os.listdir('.'):
	if endsWith(filename, '.jpg', '.png', '.gif'):
		print filename
