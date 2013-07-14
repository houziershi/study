# encode=utf-8

uniStr = u"Hello world"

rec = uniStr.encode("ascii")
print rec
rec = unicode(rec,"ascii")
print rec

rec = uniStr.encode("iso-8859-1")
print rec
rec = unicode(rec,"iso-8859-1")
print rec

rec = uniStr.encode("utf-8")
print rec
rec = unicode(rec,"utf-8")
print rec

