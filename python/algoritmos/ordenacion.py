#-*- coding: utf-8 -*-
from os import sys

def seleccion(lista):
    for i in range(len(lista)):
        menor = i
        for j in range(i + 1,  len(lista)):
            if lista[j] < lista[menor]:
                menor = j
        lista[menor], lista[i] = (lista[i], lista[menor])

    return lista

def insercion(lista):
    for i in range(1, len(lista)):
        dato, j , limite = (lista[i], i, 0)
        while j != limite:
            if lista[j-1] < dato:
                limite = j
            else:
                lista[j] = lista[j-1]
                j-= 1
        lista[j] = dato        

    return lista

def intercambio(lista):
    for i in range(len(lista)):
        j = 0
        while j != len(lista)-i-1:
            if lista[j+1] <= lista[j]:
                lista[j], lista[j+1] = (lista[j+1], lista[j])
            j+=1
    return lista


#if sys.version[0] == '2':
#    entrada = raw_input('Introduzca una lista de numeros separados por espacios:\n').strip()
#else:
#    entrada = input('Introduzca una lista de numeros separados por espacios:\n').strip()

#lista = [int(i) for i in entrada.split()]
lista = [1, 5, 3, 2, 2, 4, 64, 23, 10, 12, 13, 9, 32, 22]

l = lista
print('selección   %s' % seleccion(l))

l = lista
print('inserción   %s' % insercion(l))

l = lista
print('intercambio %s' % intercambio(l))