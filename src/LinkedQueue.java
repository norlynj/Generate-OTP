import java.util.Queue;

public class LinkedQueue<E>{
    // empty list. This class is already defined in the week 2 module.
    private SinglyLinkedList<E> list = new SinglyLinkedList();


    public int size() { return list.getSize(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void enqueue(E e) { list.addLast(e); }

    public E first() { return list.first(); }

    public E dequeue() { return list.removeFirst(); }

    public void display(){
        list.display();
    }
}