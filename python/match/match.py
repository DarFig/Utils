# -*- coding: utf-8 -*-

from reader import Reader

r = Reader("configFile.txt")

a = r.openAllFiles()

lines = r.getLines(0)

for line in lines:
    print(line)

r.closeAllFile()

