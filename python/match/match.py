# -*- coding: utf-8 -*-

from reader import Reader
from writer import Writer
from tests import *
import re




def main():
  entyDicc = {}
  exDicc = {}

  r = Reader("configFile.txt")
  w = Writer()
  w.openAllFiles()


  a = r.openAllFiles()

  lines = r.getLines(0)


  for i in range(1, r.getFilesNumber()):
    file = r.getLines(i)
    for line in lines:
      cad = getTablasYPropiedades(line)
      if(cad is not ""):
        for c in cad:
          if (c not in entyDicc): 
            entyDicc[c] = c
            w.setLine(1, c+"\n\r")
      line = re.findall('#[A-Za-z0-9]+', line)
      if(len(line)> 0):
        line = line[0].split('#')[1]
        test1(line, file, w, exDicc)
        
  testFinal(entyDicc, exDicc, w)


  r.closeAllFile()
  w.closeAllFile()


main()