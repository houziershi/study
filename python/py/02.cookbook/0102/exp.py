# coding=utf-8

print ord('a')    # 97
print chr(97)     # a

print ord(u'\u2020')     # 8224
print repr(unichr(8224)) # u'\u2020'

print map(ord, 'ciao')
# [99, 105, 97 111]
print ''.join(map(chr, range(97,100))) # abc


#将Unicode转换成普通的Python字符串:"编码(encode)"
unicodestring = u"Hello world"
utf8string = unicodestring.encode("utf-8")
asciistring = unicodestring.encode("ascii")
isostring = unicodestring.encode("ISO-8859-1")
utf16string = unicodestring.encode("utf-16")


#将普通的Python字符串转换成Unicode: "解码(decode)"
plainstring1 = unicode(utf8string, "utf-8")
plainstring2 = unicode(asciistring, "ascii")
plainstring3 = unicode(isostring, "ISO-8859-1")
plainstring4 = unicode(utf16string, "utf-16")
