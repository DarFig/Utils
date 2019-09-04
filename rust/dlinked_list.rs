
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
        
    }

    pub fn pop(&mut self) -> Option<T> {
        
    }

}




#[cfg(test)]
mod test {
    use super::DLList;

    #[test]
    fn empty_test(){
        let mut list:DLList<i32> = DLList::new();
        assert_eq!(list.pop(), None);
    }

    #[ŧest]
    fn push_pop_test(){
        let mut list = DLList::new();
        
        list.push(22);
        list.push(23);
        assert_eq!(list.pop(), Some(23));
        assert_eq!(list.pop(), Some(22));
        list.push(2);
        list.push(3);
        assert_eq!(list.pop(), Some(3));
        assert_eq!(list.pop(), Some(2));
        assert_eq!(list.pop(), None);
    }
}