# -*- coding: utf-8 -*-

from intention import EngineClass

if __name__== "__main__":
    tokens = ["convocatoria", ". lugar", "fecha."]
    engine = EngineClass("convocatoria uno lugar dos fecha tres", tokens)
    print(engine.run("convocatoria uno lugar dos fecha tres"))
