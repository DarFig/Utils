# -*- coding: utf-8 -*-

def test1(tag, file):
    for aux in file:
        if(tag in aux):
            print("match: ",tag," ---- ", aux)
    return tag