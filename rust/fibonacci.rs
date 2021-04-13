struct Fib{
    n1: u32,
    n2: u32,
}

impl Iterator for Fib{
    type Item = u32;
    fn next(&mut self) -> Option<u32> {
        let n2 = self.n1 + self.n2;
        self.n1 = self.n2;
        self.n2 = n2;
        
        Some(self.n1)
    }
}

fn fib() -> Fib {
    Fib{n1:1, n2:1}
}

fn main() {
    for j in fib().take(5){
        println!("{}", j);
    }
    println!("-----");
    for j in fib().skip(5).take(4){
        println!("{}", j);
    }
    
    
}