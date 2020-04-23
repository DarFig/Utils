use piston_window::*;
use piston_window::types::Color;

use rand::{thread_rng, Rng};


use direction::Direction;
use snake::Snake;
use draw::{draw_pixel, draw_square};

const BORDER_COLOR: Color = [0.5, 0.0, 0.5, 1.0];
const APPLE_COLOR: Color = [0.8, 0.1, 0.1, 1.0];
const GAMEOVER_COLOR: Color = [0.8, 0.0, 0.2, 0.5];

const INITIAL_PERIOD: f64 = 0.2;
const MINIMAL_PERIOD: f64 = 0.08;
const RESTART_TIME: f64 = 1.0;


pub struct Game {
    snake: Snake,
    apple_exists: bool,
    apple_x: i32,
    apple_y: i32,
    width: i32,
    height: i32,
    period: f64,
    game_over: bool,
    waiting_time: f64,
}

impl Game {
    pub fn new(width: i32, height: i32) -> Game {
        let mut random = thread_rng();
        Game {
            snake: Snake::new(2,2),
            waiting_time: 0.0,
            apple_exists: true,
            apple_x: random.gen_range(2, width-5),
            apple_y: random.gen_range(2, height-5),
            width,
            height,
            period: INITIAL_PERIOD,
            game_over: false
        }
    }
    // private functions
    fn check_if_eating(&mut self){
        let (head_x, head_y): (i32, i32) = self.snake.head_position();
        if self.apple_exists && self.apple_x == head_x && self.apple_y == head_y {
            self.apple_exists = false;
            self.snake.restore_tail();
        }
    } 

    fn check_if_snake_alive(&self, direction: Option<Direction>) -> bool{
        let (new_x, new_y) = self.snake.next_head(direction);

        if self.snake.tail_collision(new_x, new_y){
            return false;
        }
        new_x > 0 && new_y > 0 && new_x < self.width -1 && new_y < self.height -1
    }

    fn new_apple(&mut self) {

        let mut random = thread_rng();
        let mut new_x = random.gen_range(1, self.width-1);
        let mut new_y = random.gen_range(1, self.height-1);
        
        while self.snake.tail_collision(new_x, new_y){
            new_x = random.gen_range(1, self.width-1);
            new_y = random.gen_range(1, self.height-1);    
        }
        self.apple_x = new_x;
        self.apple_y = new_y;   
        self.apple_exists = true;
    }

    fn update_snake(&mut self, direction: Option<Direction>) {
        if self.check_if_snake_alive(direction) {
            self.snake.move_forward(direction);
            self.check_if_eating();
        }else{
            self.game_over = true;
        }
        self.waiting_time = 0.0;
    }

    fn restart(&mut self){
        let mut random = thread_rng();
        self.snake = Snake::new(2,2);
        self.waiting_time = 0.0;
        self.apple_exists = true;
        self.apple_x = random.gen_range(2, self.width-5);
        self.apple_y = random.gen_range(2, self.height-5);
        self.period = INITIAL_PERIOD;
        self.game_over = false;
    }

    // public functions
    pub fn draw(&self, con: &Context, graphics: &mut G2d) {
        self.snake.draw(con, graphics);
        if self.apple_exists {
            draw_pixel(APPLE_COLOR, self.apple_x, self.apple_y, con, graphics);
        }

        draw_square(BORDER_COLOR, 0, 0, self.width,1,con,graphics);
        draw_square(BORDER_COLOR, 0, self.height -1,self.width,1,con,graphics);
        draw_square(BORDER_COLOR, 0, 0, 1, self.height,con,graphics);
        draw_square(BORDER_COLOR, self.width - 1, 0,1, self.height, con,graphics);
        if self.game_over {
            draw_square(GAMEOVER_COLOR, 0, 0, self.width,self.height,con,graphics);
        }
    }

       

    pub fn update(&mut self, delta_time: f64) {
        self.waiting_time += delta_time;
        
        if self.game_over {
            if self.waiting_time > RESTART_TIME {
                self.restart();
            }
            return;
        }
        if self.waiting_time > self.period{
            self.update_snake(None);
        }
        if !self.apple_exists {
            self.new_apple();
            if self.period > MINIMAL_PERIOD {
                //incrementar la velocidad del juego
                self.period-=0.01;
            }
        }
        

    }

    pub fn key_pressed(&mut self, key: Key){
        if self.game_over {
            return;
        }

        let direction = match key {
            Key::Up => Some(Direction::Up),
            Key::Down => Some(Direction::Down),
            Key::Left => Some(Direction::Left),
            Key::Right => Some(Direction::Right),
            _ => None
        };

        //si la tecla corresponde a una dirección
        if  direction != None {
            if direction.unwrap() == self.snake.head_direction().get_inverse(){
                return;
            }
            self.update_snake(direction);
        }
        
    }
}