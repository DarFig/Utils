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

with abrir("configFile.txt", encoding="utf-8") as confFile:
    documents = confFile.readline()
    documents = documents.split(';')


def openAllFiles():
    listFiles = []
    for i in range(len(documents)):
        listFiles.insert(1, abrir(documents[i], encoding="utf-8")) 
    return listFiles

def closeAllFile(listFiles):
    for file in listFiles:
        file.close()

