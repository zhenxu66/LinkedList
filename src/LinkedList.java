public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e = e;
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    //private Node head;
    private Node dummyHead;

    private int size;

    public LinkedList(){
        //head = null;
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

//    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//
//        //or head = new Node(e, head);
//
//        size++;
//    }

    public void add(int index, E e){
        if (index<0 || index > size){
            throw new IllegalArgumentException("Add failure, Illegal Index");
        }

//        if(index == 0)
//            addFirst(e);
//        else{
//
//            Node prev = head;
//            for(int i=0; i<index; i++)
//                prev = prev.next; //go through (index-1) iterations to update previous Node
//
//            prev.next = new Node(e,prev.next);
//            //create new node, link prev.next to this new node.next, link this node to prev.next
//            size ++;
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next; ////go through (index) iterations to update previous Node
        }

        prev.next = new Node(e,prev.next);
        size ++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if (index<0 || index >= size){
            throw new IllegalArgumentException("get failure, Illegal Index");
        }

        Node cur = dummyHead.next;
        for(int i = 0;i < index; i++){
            cur=cur.next;
        }
        return(cur.e);
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E e){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("get index invalid");
        }

        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("remove index invalid");
        }

        Node prev = dummyHead;

        size --;

        for(int i = 0; i < index; i++){
            prev = prev.next; ////go through (index) iterations to update previous Node
        }
        Node retNode = prev.next; //must store here to be returned
        prev.next = prev.next.next; //or prev.next
        retNode.next = null; //take back memory to be specfied
        return retNode.e;

//        prev.next = prev.next.next;
//        prev.next.next = null;
//        //this logic will
//        return prev.next.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
//        Node cur = dummyhead.next;
//        while(cur != null){
//            res.append(cur + "-->");
//            cur = cur.next;
//        }

        for(Node cur = dummyHead.next; cur != null; cur=cur.next){
            res.append(cur + ">>");
        }

        //res can append Node or Node.e with StringBuilder and divider

        res.append("NULL");
        //better not use key word

        return res.toString();
    }


}
