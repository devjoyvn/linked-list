package LinkedList;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Insert to head of Linked list
     *
     * @Param: T data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    /**
     * Insert to end of Linked list
     *
     * @Param: T data
     */

    public void addEnd(T data) {
        Node<T> newNode = new Node<>(data);
        // If the Linked list is empty, newNode will be head node
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        // Go to the last node
        Node<T> last = this.head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        // Append newNode to end the linked list
        last.setNext(newNode);
    }


    /**
     * Insert newNode to a posotion in linked list
     *
     * @Param: T data, int pos
     */

    public void addPos(T data, int pos) {
        if (pos < 0) {
            return;
        }

        // If pos is zero, It's add to first
        if (pos == 0) {
            this.addFirst(data);
            return;
        }

        int i = 0;
        Node<T> cur = this.head;
        while (i < pos - 1 && cur != null) {
            i++;
            cur = cur.getNext();
        }

        // pos is outIndex of linked list
        if (i != pos - 1) {
            return;
        }

        // insert newNode to pos

        Node<T> newNode = new Node<>(data);
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
    }

    /**
     * Remove element in linked list by pos
     *
     * @Param int pos
     */

    public boolean removePos(int pos) {
        if (pos < 0) {
            return false;
        }

        if (pos == 0) {
            this.removeHead();
        }

        int i = 0;
        Node<T> cur = this.head;
        while (i < pos - 1 && cur != null) {
            i++;
            cur = cur.getNext();
        }

        // pos is outIndex of linked list
        if (i != pos - 1) {
            return false;
        }

        cur.setNext(cur.getNext().getNext());
        return true;
    }


    /**
     * Remove element in linked list by key in the first meeting
     *
     * @Param T key
     */

    public boolean removeAtFirst(T key) {
        if (this.head.getData().equals(key)) {
            this.removeHead();
            return true;
        }

        Node<T> cur = this.head;
        while (cur.getNext() != null && !cur.getNext().getData().equals(key)) {
            cur = cur.getNext();
        }
        if (cur.getNext() == null)
            return false;

        cur.setNext(cur.getNext().getNext());
        return true;
    }


    /**
     * Remove element in linked list by key in the last meeting
     *
     * @Param T key
     */

    public boolean removeAtLast(T key) {
        if (this.head.getData().equals(key) && !this.isUniqueInRange(this.head, key)) {
            this.removeHead();
            return true;
        }

        Node<T> cur = this.head;
        while (cur.getNext() != null && !cur.getNext().getData().equals(key) || this.isUniqueInRange(cur.getNext(), key)) {
            cur = cur.getNext();
        }

        if (cur.getNext() == null)
            return false;

        cur.setNext(cur.getNext().getNext());
        return true;
    }

    /**
     * Remove element the first at the top of Linked list
     */

    public void removeHead() {
        this.head = this.head.getNext();
    }

    /**
     * Remove element the first at the top of Linked list
     */

    public void removeLast() {
        if (this.head == null)
            return;

        if (this.head.getNext() == null)
            removeHead();

        Node<T> preLast = this.head;
        while (preLast.getNext().getNext() != null) {
            preLast = preLast.getNext();
        }
        preLast.setNext(null);
    }

    /**
     * Print all the element of linked list
     */

    public void printAll() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

    /**
     * Get size of linked list
     */

    public int size() {
        int count = 0;
        Node<T> cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    /**
     * Search element in linked list
     *
     * @return -1 if linked list don't contain data
     * @Param T data
     */
    public int find(T data) {
        int pos = 0;
        Node<T> cur = this.head;
        while (cur != null) {
            if (cur.getData().equals(data))
                return pos;
            cur = cur.getNext();
            pos++;
        }
        return -1;
    }

    private boolean isUniqueInRange(Node<T> cur, T data) {
        if (cur == null)
            return false;
        while (cur.getNext() != null) {
            if (cur.getNext().getData().equals(data))
                return true;
            cur = cur.getNext();
        }
        return false;
    }

}
