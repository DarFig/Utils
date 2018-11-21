# -*- coding: utf-8 -*-

from pathlib import Path
import sys

def ls(ruta = "./../xml/"):
    return [arch.name for arch in Path(ruta).iterdir() if arch.is_file()]


f = open("configFile.txt", "w",encoding="utf-8") 

lista = ls()
f.write("./../mainFile.ext")
for l in lista:
    f.write(";./../xml/"+l) 
