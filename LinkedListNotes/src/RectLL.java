public class RectLL {

    private RectNode head;

    public RectLL() {
        head = null;
    }

    /**
     * This method adds a rectangle to the list in the last possible location.
     * @param x the Rectangle to add.
     */
    public void add(Rectangle x) {

        // situation 1: You alter/affect the head
        // situation 2: You alter something after the head.
        if(head == null) {
            head = new RectNode(x);
        } else {

            // This is a traversal to get to the end of the list.
            RectNode travs;
            travs = head;

            while(travs.next != null) {
                travs = travs.next;
            }
            travs.next = new RectNode(x);
        }

    }

    public String toString() {
        String result = "";

        if(head == null) {
            result = " ";
        }

        RectNode current; // another way to name traversal.
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
    public void remove(Rectangle x) {

        if(head == null) {
            return; // nothing to return.
        }

        if(head.data.equals(x)) {
            head = head.next; // moves where the first pointer is pointing to, and the garbage collector will delete the first element that has not pointers(old one)
            return;
        }

    }

}
