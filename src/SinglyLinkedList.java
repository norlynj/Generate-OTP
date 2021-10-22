public class SinglyLinkedList<E>{
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

    public E removeLast(){
        if(isEmpty()){ return null; }

        if(size == 1){ return removeFirst(); }

        Node<E> prev = null;
        Node<E> e = (Node<E>) head.getElement();

        while(e.getNext() != null){
            prev = e;
            e = e.getNext();
        }

        prev.setNext(null);
        size--;
        return e.getElement();
    }

    public Node<E> getHead(){
        return head;
    }
}
