#ifndef BASIC_CELL_H
#define BASIC_CELL_H

/*
### Variable info_in

- vacio 0
- negrto 2
- negro y blanco 3

### Variable my_input

- 0 nada
- 1 blanco
- 2 negro

*/

int basic_cell(int* input, int* info_in, int* info_out)
{
    if(input == 2) info_out = 2;
    else if(input == 1 && (info_in == 2 || info_in == 3)) info_out = 3;
    else info_out = 0;

    return if(info_in == 3 && input == 0);
}







#endif
