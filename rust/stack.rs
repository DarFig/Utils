
type Link<T> = Option<Box<Node<T>>>;


pub struct Stack<T>{
    top: Link<T>,

}

struct Node<T> {
    data: T,
    next: Link<T>,
}

impl<T> Stack<T> {
    pub fn new() -> Self {
        Stack {top: None}
    }

    pub fn push(&mut self, data: T) {
        let node = Box::new(Node {
        data: data,
        next: self.top.take(),
        }); 
        self.top = Some(node);
    }

    pub fn pop(&mut self) -> Option<T> {
        self.top.take().map(|node| {
            self.top = node.next;
            node.data
        })
    }

}

impl<T> Drop for Stack<T> {
    fn drop(&mut self) {
        let mut actual = self.top.take();
        while let Some(mut link) = actual {
            actual = link.next.take();
        }
    }
}

#[cfg(test)]
mod test {
    use super::Stack;
    #[test]
    fn empty_test(){
        let mut stack:Stack<i32> = Stack::new();
        assert_eq!(stack.pop(), None);
    }

    #[test]
    fn push_pop_test(){
        let mut stack = Stack::new();
        
        stack.push(22);
        stack.push(23);
        assert_eq!(stack.pop(), Some(23));
        assert_eq!(stack.pop(), Some(22));
        stack.push(2);
        stack.push(3);
        assert_eq!(stack.pop(), Some(3));
        assert_eq!(stack.pop(), Some(2));
        assert_eq!(stack.pop(), None);
    }

}