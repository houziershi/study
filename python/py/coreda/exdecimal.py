# coding=utf-8

import decimal

d = decimal.Decimal('3.141')

print d+1

print decimal.Decimal('0.1') + decimal.Decimal('0.1') + decimal.Decimal('0.1') 
print decimal.Decimal('1') / decimal.Decimal('7') 

# set precision
decimal.getcontext().prec = 4
print decimal.Decimal('1') / decimal.Decimal('7') 
