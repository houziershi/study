# coding=utf-8

import struct

bytes = struct.pack('>i4sh',1,'spam',2)
print bytes

outfile = open('data.bin','wb')
outfile.write(bytes)
outfile.close()

infile = open('data.bin','rb')
data = infile.read()
infile.close()

print data

obj = struct.unpack('>i4sh',data)
print obj              

