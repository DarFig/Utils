/*
Esto es solo un ejercicio para a modo de práctica basado en un tutorial

- Se ha añadido el reinicio con la manzana en posiciones aleatorias.
- Se hahecho que la velocidad del juego aumente cada vez que se come
para aumentar gradualmente la dificultad.
*/


extern crate piston_window;
extern crate rand;


mod utils;
mod draw;
mod snake;
mod direction;
mod game;


use piston_window::*;
use piston_window::types::Color;

use crate::game::Game;
use crate::utils::i32_to_u32;

const BACKGROUND_COLOR: Color = [0.2, 0.2, 0.2, 1.0];

fn main(){
    //tamaño de la ventana
    let (width, height) = (35, 30);

    let mut game = Game::new(width, height);
    let mut game_window: PistonWindow =
        WindowSettings::new(
            "SNAKE GAME", [i32_to_u32(width), i32_to_u32(height)])
            .exit_on_esc(true).build().unwrap();

    // bucle principal
    while let Some(event) = game_window.next() {
        if let Some(Button::Keyboard(key)) = event.press_args() {
            game.key_pressed(key);
        }

        game_window.draw_2d(&event, |c, graphics, _| {
            clear(BACKGROUND_COLOR, graphics);
            game.draw(&c, graphics);
        });

        event.update(|arg| {
            game.update(arg.dt);
        });
    }

}