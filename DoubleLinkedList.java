public class DoubleLinkedList {
    class Node {
        int Element;
        Node Prev, Next;

        public Node(int Element, Node Prev, Node Next) {
            this.Element = Element;
            this.Prev = Prev;
            this.Next = Next;
        }
    }
    protected Node Head = null;
    protected Node Tail = null;
    protected int size = 0;
    
    /**
     * to check DLL is Empty
     * @return 
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * to create new node in first DLL
     * @param newElement 
     */
    public void addFirst(int newElement){
        if (isEmpty()) {
            Head = new Node(newElement, null, null);
            Tail = Head;
        } else {
            Head.Prev = new Node(newElement, null, Head);
            Head = Head.Prev ;
        }
        
        size++;
    }
    
    /**
     * to create new Node in last DLL
     * @param newElement 
     */
    public void addLast(int newElement){
        if (isEmpty()) {
            addFirst(newElement);
            return;
        }
        Tail.Next = new Node(newElement, Tail, null);
        Tail = Tail.Next;
        size++;
    }
    
    /**
     * to Create new node after element
     * @param Element
     * @param newElement 
     */
    public void add(int Element, int newElement){
        if (isEmpty()) {
            addFirst(newElement);
            return;
        }
        Node pointer = Head;
        while (pointer.Element != Element && pointer != null){
            pointer = pointer.Next;
        }
        if (pointer == Tail) {
            addLast(newElement);
        } else if (pointer.Element == Element) {
            Node pointer2 = pointer.Next;
            pointer.Next = new Node(newElement, pointer, pointer2);
            pointer2.Prev = pointer.Next;
            size++;
            if (pointer == Tail) {
                Tail = pointer.Next;
            }
        }
    }
    
    /**
     * to create new node by sorting
     * @param newElement 
     */
    public void addSort(int newElement){
        if (isEmpty()) {
            addFirst(newElement);
            return;
        }
        Node pointer = Head;
        while(pointer != null){
            if (pointer.Element > newElement) {
                break;
            }
            pointer = pointer.Next;
        }
        if (pointer == Head) {
            addFirst(newElement);
            return;
        } else if (pointer == null ){
            addLast(newElement);
            return;
        }
        pointer.Prev.Next = new Node(newElement, pointer.Prev, pointer);
        pointer.Prev = pointer.Prev.Next;
        size++;
    }
    
    /**
     * to remove node first
     * @return 
     */
    public boolean removeFirst(){
        if (isEmpty()) {
            return false;
        }
        if (size == 1){
            Head = null;
            Tail = Head;
            size--;
            return true;
        }
        Head = Head.Next;
        Head.Prev = null;
        size--;
        return true;
    }
    
    /**
     * to remove node last
     * @return 
     */
    public boolean removeLast(){
        if (size<2) {
            return removeFirst();
        }
        Tail = Tail.Prev;
        Tail.Next = null;
        size--;
        return true;
    }
    
    /**
     * to remove node Element
     * @param Element
     * @return 
     */
    public boolean removeItem(int Element){
        Node pointer = Head;
        while(pointer != null){
            if(pointer.Element == Element){
                break;
            }
            pointer = pointer.Next;
        }
        
        if (pointer == null){
            return false;
        } else if (pointer == Head) {
            return removeFirst();
        } else if(pointer == Tail) {
            return removeLast();
        } 
        pointer.Prev.Next = pointer.Next;
        pointer.Next.Prev = pointer.Prev;
        size--;
        return true;
        
    }
    
    /**
     * to print node
     * @param Comment 
     */
    public void cetak(String Comment){
        System.out.println(Comment+" | "+size);
        Node temp = Head;
        System.out.print("null<->");
        while(temp!=null){
            System.out.print(temp.Element+"<->");
            temp = temp.Next;
        }
        System.out.println("null");
    }
}
