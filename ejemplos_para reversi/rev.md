## Ayuda

### Variable info_in

- vacio 00
- negrto 10
- negro y blanco 11

### Variable my_input

- 00 nada
- 01 blanco
- 10 negro

### Lógica

my_output = 1 si (info_in == 11 and my_input == 00 );

info_out = 10 si ( my_input == 10) sino
			= 11 si ( my_input == 01 and (info_in == 10 o info_in == 11)) sino
			= 00