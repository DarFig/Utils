# -*- coding: utf-8 -*-

from intention import EntitiesEngine

if __name__== "__main__":
    tokens = ["convocatoria", ". lugar", ". tipo", ". examen" ,". fecha"]
    engine = EntitiesEngine("convocatoria uno lugar dos fecha tres", tokens)
    
    print(engine.run("convocatoria uno fecha tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno lugar dos")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno tipo tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno examen tres")," + " ,engine.getEntities())

    print(engine.run("convocatoria uno lugar dos fecha tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno lugar dos tipo tres")," + " ,engine.getEntities()) 
    print(engine.run("convocatoria uno tipo dos fecha tres ")," + " ,engine.getEntities())

    print(engine.run("convocatoria uno lugar dos examen tres")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno tipo dos examen tres")," + " ,engine.getEntities()) 
    print(engine.run("convocatoria uno examen dos fecha tres ")," + " ,engine.getEntities())
    print(engine.run("convocatoria uno")," + ", engine.getEntities())  
