public class nodeCoin {
    Node head;
    Node tail;
    int size;

    nodeCoin() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    void insert(Node node) {
        if (this.isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.nextHash = this.head;
            head.prevHash = node;
            head = node;
        }
        size++;
    }


        return "-1";
    }
}