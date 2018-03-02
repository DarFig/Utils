#ifndef BASIC_CELL_H
#define BASIC_CELL_H

int basic_cell(int* input, int* info_in, int* info_out)
{
    if(input == 2) info_out = 2;
    else if(input == 1 && (info_in == 2 || info_in == 3)) info_out = 3;
    else info_out = 0;

    return if(info_in == 3 && input == 0);
}







#endif
