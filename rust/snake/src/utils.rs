
pub const PIXEL_SIZE: f64 = 20.0;

#[derive(Clone)]
pub struct Pixel {
    pub x_cord: i32,
    pub y_cord: i32,
}



pub fn i32_to_f64(number: i32) -> f64 {
    (number as f64) * PIXEL_SIZE
}

pub fn i32_to_u32(number: i32) -> u32 {
    i32_to_f64(number) as u32
}
