
public class LinkedStack<E>{

    private SinglyLinkedList<E> list = new SinglyLinkedList();

    public LinkedStack() {}

    public int size() { return list.getSize(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void push(E e) { list.addFirst(e); }

    public E top() { return list.first(); }

    public E pop() { return list.removeFirst(); }

    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        int i = size();
        while(i>0)
        {
            System.out.print( top() );
            System.out.print(' ');
            i--;
        }
        System.out.println("");
    }

}
