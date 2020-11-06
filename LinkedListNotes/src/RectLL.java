public class RectLL<E extends Comparable<E> > { // The <E> is makes the class take any object, probably would have to change the name

    private class RectNode <E> { // Called an inner class.

        public E data; // Now acceptable to have public fields because the class as a whole is private.
        public RectNode<E> next;

        public RectNode(E x) {
            data = x;
            next = null; // Not actually needed, all new references are set to nul by default
        }

    }

    private RectNode<E> head;
    private int size;

    public RectLL() {
        head = null;
        size = 0;
    } // End class

    /**
     * This method adds a rectangle to the list in the last possible location.
     * @param x the Rectangle to add.
     */
    public void add(E x) {

        // situation 1: You alter/affect the head
        // situation 2: You alter something after the head.
        if(head == null) {
            head = new RectNode<E>(x);
            size++;
        } else {

            // This is a traversal to get to the end of the list.
            RectNode travs;
            travs = head;

            while(travs.next != null) {
                travs = travs.next;
            }
            travs.next = new RectNode<E>(x);
            size++;
        }

    }

    public String toString() {
        String result = "";

        if(head == null) {
            result = " ";
        }

        RectNode<E> current; // another way to name traversal.
        current = head;

        while(current != null) {
            result = result + "," + current.data.toString();
            current = current.next; // VERY IMPORTANT to make sure to step forward.
        }
        return "[" + result.substring(1) + "]"; // substring(1) will take out the first comma.
    }

    /**
     * Remove a particular Rectangle from the list, note
     * this is not by index, equality.
     * @param x the Rectangle o remove.
     */
    public void remove(E x) {

        if(head == null) {
            return; // nothing to return.
        }

        if(head.data.equals(x)) {
            head = head.next; // moves where the first pointer is pointing to, and the garbage collector will delete the first element that has not pointers(old one)
            size--;
            return;
        }

        // Day 2
        RectNode<E> current = head;
        RectNode<E> back = head;

        while(current != null && !current.data.equals(x)) {
            back = current;
            current = current.next;
        }

        if(current == null) return;

        // else
        back.next = current.next;
        size--;

    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(E x) {
        RectNode<E> current = head;

        while(current != null) {
            if(current.data.equals(x)) return true;
            current = current.next;
        }

        return false;

    }

    public void sort() {
        // First off all, the data (E) needs to be sortable
        // Class must be sortable?? Must implement the compareTo AKA Extends comparable
    }

    public void add(int index, E x) {

        if(index < 0) throw new IllegalArgumentException("Index cannot be negatives");
        if(index > size) throw new IllegalArgumentException("Index cannot be greater than the size.");
        if(index == size) add(x);
        else if(index == 0) {
            RectNode<E> temp = new RectNode<E>(x);
            temp.next = head;
            head = temp;
            size++;
        } else { // add to the middle
            RectNode<E> current = head;
            for(int i = 1; i < index; i++) current = current.next;

            RectNode<E> temp = new RectNode<E>(x);
            temp.next = current.next;
            current.next = temp;
            size++;

        }
    }

}
