
public class Queue<E>{
    public static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement() { return element; }

        public Node<E> getNext() { return next; }

        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    //acess methods
    public boolean isEmpty() { return size == 0; }

    public E first() { return isEmpty() ? null : head.getElement(); }

    public E last() { return isEmpty() ? null : tail.getElement(); }

    public int getSize() { return size; };

    //update methods
    public void enqueue(E e){
        Node<E> newNode = new Node<>(e, null);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E dequeue(){
        if(isEmpty()){ return null; }
        Node<E> e = (Node<E>) head;
        head = head.getNext();
        size--;
        tail = size == 0 ? null : tail;
        return e.getElement();
    }


}
