# -*- coding: utf-8 -*-


def test1(tag, file, w):
    tag_aux = ""
    for aux in file:
        if(tag in aux):
            if tag != tag_aux :
                w.setLine(0, tag+"\n\r")
                tag_aux = tag
            w.setLine(0, "        "+aux+"\n\r")
    return tag



        