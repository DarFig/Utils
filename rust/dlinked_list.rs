
type Link<T> = Option<Box<Node<T>>>;

struct Node<T> {
    data: T,
    left: Link<T>,
    right: Link<T>,
}

pub struct DLList<T> {
    head: Link<T>,
    tail: Link<T>,
}

impl <T> DLList<T> {
    pub fn new() -> Self {
        DLList {
            head: None, tail:None
        }
    }

    pub fn push(&mut self, data: T) {
        let new_tail = Box::new(Node {
            data: data,
            left: self.tail.take(),
            right: None,
        });
        let ttail: *mut _ = &mut *new_tail;

        if !self.tail.is_null() {
            unsafe{
                (*self.tail).right = Some(new_tail);   
            }
        }else{
            self.head = Some(ttail);
        }
        self.tail = ttail;
    }

    

}