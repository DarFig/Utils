#include <stdio.h>
//gcc main.c -o main
#define FILA 8
#define COL 8

int posibles_jugadas(int tablero[][COL], int movimientos[][COL]){
  int tot_mov = 0;
  int p = 0, q = 0;
  for(int i = 0; i < FILA; i++){
    for(int j = 0; j< COL; j++){
      if(tablero[i][j] == 2){//si es negro
        //buscamos un blanco
        if(tablero[i-1][j-1] == 1){//es blanco
          p = i-2, q = j-2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p--; q--;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i-1][j] == 1){//es blanco
          p = i-2, q = j;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p--;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i-1][j+1] == 1){//es blanco
          p = i-2, q = j+2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p--; q++;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i][j-1] == 1){//es blanco
          p = i, q = j-2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            q--;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i][j+1] == 1){//es blanco
          p = i, q = j+2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            q++;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i+1][j-1] == 1){//es blanco
          p = i+2, q = j-2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p++; q--;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i+1][j] == 1){//es blanco
          p = i+2, q = j;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p++;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
        if(tablero[i+1][j+1] == 1){//es blanco
          p = i + 2, q = j + 2;
          while(p >= 0 && q >= 0 && p <= 7 && q <= 7 && tablero[p][q] == 1){//sigue siendo blanco
            p++; q++;
          }
          if(tablero[p][q] == 0){
            tot_mov++;
            movimientos[p][q] = 3;
          }
        }
      }
    }
  }
  return tot_mov;
}

void imprime(int t[][COL]){
  for(int i = 0; i < 8; i++){
    printf("%i: %i %i %i %i %i %i %i %i\n", i, t[i][0], t[i][1], t[i][2], t[i][3], t[i][4], t[i][5], t[i][6], t[i][7]);
  }

}

int main(){
  /*
    tablero
    0 - nada
    1 - blanco
    2 - negro
    movimientos
    0 - 2 idem
    3 posible movimiento
  */
  int tablero[FILA][COL] = {
                    //0 1 2 3 4 5 6 7
                     {0,0,1,2,0,0,0,0},//0
                     {0,1,2,0,0,0,0,0},//1
                     {0,0,0,0,0,0,0,0},//2
                     {0,0,0,1,2,0,0,0},//3
                     {0,0,1,2,0,0,0,0},//4
                     {0,0,0,0,0,0,0,0},//5
                     {0,0,0,0,1,2,0,0},//6
                     {0,0,0,0,0,1,2,0}};//7
  int movimientos[FILA][COL] = {
                        //0 1 2 3 4 5 6 7
                         {0,0,1,2,0,0,0,0},//0
                         {0,1,2,0,0,0,0,0},//1
                         {0,0,0,0,0,0,0,0},//2
                         {0,0,0,1,2,0,0,0},//3
                         {0,0,1,2,0,0,0,0},//4
                         {0,0,0,0,0,0,0,0},//5
                         {0,0,0,0,1,2,0,0},//6
                         {0,0,0,0,0,1,2,0}};//7

  int sol = posibles_jugadas(tablero, movimientos);
  printf("Número de posibles movimientos %i\n", sol);
  imprime(movimientos);
  return 0;
}
