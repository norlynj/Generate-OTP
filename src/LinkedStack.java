public class LinkedStack<E>{

    private SinglyLinkedList<E> list = new SinglyLinkedList();

    public int size() { return list.getSize(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void push(E e) { list.addFirst(e); }

    public E top() { return list.first(); }

    public E pop() { return list.removeFirst(); }


}

