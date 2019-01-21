# -*- coding: utf-8 -*-

from intention import EntitiesEngine

if __name__== "__main__":
    tokens = ["convocatoria", ". lugar", "tipo_pub .", "fecha ."]
    engine = EntitiesEngine("convocatoria uno lugar dos fecha tres", tokens)
    print(engine.run("convocatoria uno fecha tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno lugar dos")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno tipo_pub tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno tipo_pub dos fecha tres ")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno lugar dos fecha tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno lugar dos tipo_pub tres")," + " ,engine.getEntities())       