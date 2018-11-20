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


    
class Reader():
    def __init__(self, files_route):
        with abrir(files_route, encoding="utf-8") as confFile:
            self.__documents = confFile.readline().split(';')
         
        self.listFiles = []
        

    def openAllFiles(self):
        for i in range(0,len(self.__documents)):
            self.listFiles.insert(i, abrir(self.__documents[i], encoding="utf-8")) 
        return self.listFiles

    def closeAllFile(self):
        for file in self.listFiles:
            file.close()

    def getLines(self,index):
        return self.listFiles[index].readlines()



    


