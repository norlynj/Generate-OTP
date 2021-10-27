public class SinglyLinkedList<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        private E getElement() { return element; }

        private Node<E> getNext() { return next; }

        private void setNext(Node<E> n) { next = n; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    //acess methods
    public boolean isEmpty() { return size == 0; }

    public E first() { return isEmpty() ? null : head.getElement(); }

    public int getSize() { return size; };

    //update methods
    public void addFirst(E e){
        head = new Node<>(e, head);
        tail = size == 0 ? head : null;
        size++;
    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(e, null);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){ return null; }
        Node<E> e = (Node<E>) head;
        head = head.getNext();
        size--;
        tail = size == 0 ? null : tail;
        return e.getElement();
    }



    public void display() {
        //Node e will point to head
        Node<E> e = (Node<E>) head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("OTP Queue: ");
        while(e != null) {
            //Prints each node by incrementing pointer
            System.out.println(e.element + " ");
            e = e.next;
        }
        System.out.println();
    }
}
