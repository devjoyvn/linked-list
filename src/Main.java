import LinkedList.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        linkedList.addEnd(-1);
        linkedList.addEnd(-2);
        linkedList.addEnd(-3);
        linkedList.addEnd(3);

        linkedList.removeAtLast(3);

        linkedList.printAll();
    }
}
