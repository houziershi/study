# encoding=utf-8
num = 1 / 3.0

print num
print '%e'    % num            # string formating
print '%2.2f' % num            # string formating
print '%o %x %X' % (64,64,255) # '100 40 FF'

print 1 /  3         # 0
print 1 // 3         # 0
print 1.0 / 3        # 0.33333333333
print 1.0 // 3       # 0.0

print 1 << 2         # shift left 2 bits: 0x0100 = 4
print 1 | 2          # bitwise OR:        0x0011 = 3
print 1 & 1          # bitwise AND:       0x0001 = 1

print int(3.1415)    # 3
print float(3)       # 3.0
print long(4)        # 4

print oct(64)        # 0100
print hex(64)        # 0x40

print int('0100')    # 100
print int('0100', 8) # 64
print int('0x40',16) # 64
