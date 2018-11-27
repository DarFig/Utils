# -*- coding: utf-8 -*-
import re



def test1(tag, file, w, exDicc):
    tag_aux = ""
    for aux in file:
        cad = getTablasYPropiedades1(aux)
        if(cad is not ""):
            for c in cad: 
                if (c not in exDicc): 
                    exDicc[c] = c
                    w.setLine(2, c+"\n\r")
        if(tag in aux):
            if tag != tag_aux :
                w.setLine(0, tag+"\n\r")
                tag_aux = tag
            w.setLine(0, "        "+aux+"\n\r")
    return tag



def getTablasYPropiedades(cadena):
    subcadena = ""
    subcadena = re.findall('/[A-Za-z0-9]*#[A-Za-z0-9]*',cadena)
    if("is" in subcadena or "has" in subcadena):
        subcadena = ""
    return subcadena

def getTablasYPropiedades1(cadena):
    subcadena = ""
    subcadena = re.findall('[A-Za-z0-9]*:[A-Za-z0-9]*',cadena)
    if("is" in subcadena or "has" in subcadena):
        subcadena = ""
    return subcadena


def testFinal(entyDicc, exDicc, w):
    for key,value in entyDicc.items():
        if(key.replace('#', ':').replace('/','') in exDicc):
             w.setLine(3, "match completo: "+value+"\n\r")
        else:
            for key1,value1 in exDicc.items():
                if(key.split('#')[1] in key1.split(':')[1] and key.split('#')[1]is not ""):
                    w.setLine(3, "match --------: "+value+" - "+value1+"\n\r")



        