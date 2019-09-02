
type Link<T> = Option<Box<Node<T>>>;


pub struct Stack<T>{
    top: Link<T>,

}

struct Node<T> {
    element: T,
    next: Link<T>,
}

impl<T> Stack<T> {
    pub fn new() -> Self {
        Stack {top: None}
    }

    pub fn push(&mut self, element: T) {
        let node = Box:new(Node {
        element: element,
        next: self.top.take(),
        }); 
        self.top = Some(node);
    }

    pub fn pop(&mut self) -> Option<T> {
        self.top.take().map(|Node| {
            self.top = node.next;
            node.element
        })
    }

}

impl<T> Drop for Stack<T> {
    fn drop(&mut self) {
        let mut actual = self.top.take();
        while let Some(mut link) = actual {
            actual = link.next.take()
        }
    }
}


