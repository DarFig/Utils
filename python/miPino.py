# -*- coding: utf-8 -*-

#---------------------------
# prueba simple miPino.py
# entrdas: tamaño del pino a dibujar
# salida: dibuja un pino en pantalla
#---------------------------

altura_pino = input("Altura del pino: ")
altura_pino = int(altura_pino)

#espacios en el dibujo
huecos = altura_pino - 1

#cuerpo a dibujar
hojas = 1
huecos_tronco = altura_pino - 2

while (altura_pino !=  0):
    #por línea
    for i in range(huecos):
        print(' ', end="")#no queremos el salto de línea
    for i in range(hojas):
        print('*', end="")
    print('')#salto de línea
    huecos -= 1
    hojas += 2
    altura_pino -= 1

#poner el tronco en medio
for i in range(huecos_tronco):
    print(' ', end="")
if huecos_tronco < 2 :
    print(" |")
elif huecos_tronco < 8 :
    print("|||")
else:
    print("|||")
    for i in range(huecos_tronco):
        print(' ', end="")
    print("|||")
