mod node{

    pub type NodeBox<T> = Option<Box<Node<T>>>;

    pub struct Node<T> {
        data: T,
        left: NodeBox<T>,
        right: NodeBox<T>
    }

    impl <T: PartialOrd> Node<T> {
        pub fn new(s: T) -> Node<T>{
            Node{data: s, left: None, right: None}
        }

        fn boxer(node: Node<T>)->NodeBox<T>{
            Some(Box:new(node));
        }

        pub fn set_left(&mut self, node: Node<T>){
            self.left = self::boxer(node);
        }

        pub fn set_right(&mut self, node: Node<T>){
            self.right = self::boxer(node);
        }



    }
}