use std::collections::LinkedList;
use piston_window::{Context, G2d};
use piston_window::types::Color;

use draw::draw_pixel;
use direction::Direction;
use utils::Pixel;

const SNAKE_COLOR: Color = [0.0, 0.8, 0.2, 1.0];



pub struct Snake {
    direction: Direction,
    body: LinkedList<Pixel>,
    tail: Option<Pixel>,
}

impl Snake {
    pub fn new(x_cord:i32,y_cord:i32) -> Snake{
        let mut body: LinkedList<Pixel> = LinkedList::new();
        body.push_back(Pixel{x_cord:x_cord+2, y_cord});
        body.push_back(Pixel{x_cord:x_cord+1, y_cord});
        body.push_back(Pixel{x_cord, y_cord});

        Snake {
            direction: Direction::Right,
            body,
            tail:None,
        }
    }

    pub fn draw(&self, con: &Context, graphics: &mut G2d){
        for pixel in &self.body {
            draw_pixel(SNAKE_COLOR, pixel.x_cord, pixel.y_cord, con, graphics)
        }
    }
    pub fn head_position(&self) -> (i32, i32){
        let head = self.body.front().unwrap();
        (head.x_cord, head.y_cord)
    }
    pub fn move_forward(&mut self, actual_dir: Option<Direction>) {
        match actual_dir{
            Some(d) => self.direction = d,
            None => (),
        }
        let (last_x, last_y):(i32, i32) = self.head_position();

        let new_pixel = match self.direction {
            Direction::Up => Pixel {x_cord:last_x, y_cord:last_y-1,},
            Direction::Down => Pixel {x_cord:last_x, y_cord:last_y+1},
            Direction::Left => Pixel {x_cord:last_x-1, y_cord:last_y},
            Direction::Right => Pixel {x_cord:last_x+1, y_cord:last_y},
        };
        self.body.push_front(new_pixel);
        let removed = self.body.pop_back().unwrap();
        self.tail = Some(removed);
    }
    pub fn head_direction(&self) -> Direction{
        self.direction
    }

    pub fn next_head(&self, direction: Option<Direction>) -> (i32, i32) {
        let (head_x, head_y):(i32, i32) = self.head_position();

        let mut mov_dir = self.direction;
        match direction{
            Some(d) => mov_dir = d,
            None => {}
        }
        match mov_dir {
            Direction::Up => (head_x, head_y-1),
            Direction::Down => (head_x, head_y+1),
            Direction::Left => (head_x-1, head_y),
            Direction::Right => (head_x+1, head_y),
        }
    }

    pub fn restore_tail(&mut self) {
        let pixel = self.tail.clone().unwrap();
        self.body.push_back(pixel);
    }

    pub fn tail_collision(&self, x_cord:i32, y_cord:i32) -> bool {
        for pixel in &self.body {
            if x_cord == pixel.x_cord && y_cord== pixel.y_cord {
                return true;
            }
        }
        return false;
    }

    

}