import java.util.Queue;

public class LinkedQueue<E>{
    // empty list. This class is already defined in the week 2 module.
    private SinglyLinkedList<E> list = new SinglyLinkedList();

    public LinkedQueue() {}

    public int size() { return list.getSize(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void enqueue(E e) { list.addLast(e); }

    public E first() { return list.first(); }

    public String dequeue() { return (String) list.removeFirst(); }

    public void display(){
        list.display();
    }
}