use piston_window::{rectangle, Context, G2d};
use piston_window::types::Color;

use utils::*;


pub fn draw_pixel(color: Color, x_cord:i32, y_cord:i32, con:&Context, graphics:&mut G2d) {
    let gui_x = i32_to_f64(x_cord);
    let gui_y = i32_to_f64(y_cord);

    rectangle(
        color,
        [gui_x, gui_y, PIXEL_SIZE, PIXEL_SIZE],
        con.transform,
        graphics,
    );
}

pub fn draw_square(color: Color, x_cord:i32, y_cord:i32, width:i32, height:i32, con:&Context, graphics:&mut G2d) {
    let gui_x = i32_to_f64(x_cord);
    let gui_y = i32_to_f64(y_cord);

    rectangle(
        color,
        [gui_x, gui_y, PIXEL_SIZE * (width as f64), PIXEL_SIZE* (height as f64)],
        con.transform,
        graphics,
    );
}