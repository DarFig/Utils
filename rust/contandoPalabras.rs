use std::collections::HashMap;

fn main() {

    let mut map = HashMap::new();
    let text = "Kiko come pico en el tico tanto como kiko el pico que le duele todo el plico";
    for s in text.split(|c: char| ! c.is_alphabetic()){
        let word = s.to_lowercase();
        let count = map.entry(word).or_insert(0);
        *count += 1;
    }
    let mut entries: Vec<_> = map.into_iter().collect();
    entries.sort_by(|a,b| b.1.cmp(&a.1));
    for e in entries.iter().take(3){
        println!("{} {}", e.0, e.1);
    }

}
