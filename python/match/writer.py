# -*- coding: utf-8 -*-
import sys

# revisión de la versión
if sys.version[0] == '2' :
    #2.7.x
    import io
    abrir = io.open
else:
    #3.x.x
    abrir = open


    
class Writer():
    def __init__(self):
        self.__documents = ['./intermedio.txt', './entYpropOWL.txt','./entYpropXML.txt','./final.txt']      
        self.listFiles = []
        self.__filesNumber = len(self.listFiles)

    def openAllFiles(self):
        for i in range(0,len(self.__documents)):
            self.listFiles.insert(i, abrir(self.__documents[i],"w", encoding="utf-8")) 
        self.__filesNumber = len(self.listFiles)
        return self.listFiles

    def closeAllFile(self):
        for file in self.listFiles:
            file.close()

    def setLine(self,index, line):
        return self.listFiles[index].write(line)
    
    def getFilesNumber(self):
        return self.__filesNumber