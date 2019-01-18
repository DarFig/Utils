# -*- coding: utf-8 -*-

from intention import EngineClass

if __name__== "__main__":
    tokens = ["convocatoria", ". lugar", "fecha .", "tipo_pub ."]
    engine = EngineClass("convocatoria uno lugar dos fecha tres", tokens)
    print(engine.run("convocatoria uno fecha tres"))
    print(engine.run("convocatoria uno lugar dos"))
    print(engine.run("convocatoria uno tipo_pub tres "))
    print(engine.run("convocatoria uno lugar dos fecha tres"))
    print(engine.run("convocatoria uno lugar dos tipo_pub tres"))