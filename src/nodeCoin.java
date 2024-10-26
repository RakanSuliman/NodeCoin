
public class nodeCoin  {
    Node head;
    Node tail;
    int size;

    nodeCoin() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    void insert(Node node) {

        if (this.isEmpty()) {
            head = node;
            tail = node;

        }
        else {
        node.nextHash = this.head;
        head.prevHash = node;
        head = node;
        }
        size++;
    }
    // TODO: Date(Parameter)
    Node getMax(String Date){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        Node temp = head;
        while (temp!=null){
            if (temp.getDate().equals(Date)){
                return temp;
            }
            temp = temp.nextHash;
        }
        return null;


    }

    Node removeMax(String Date){
    if (isEmpty()){
        throw new IllegalStateException();
    }
    Node temp = head;
    while (temp!=null){
        if (temp.getDate().equals(Date)){
            temp.root.RemoveMax();
            return temp;
        }
        temp = temp.nextHash;
    }
    return null;
    }
    // TODO: Date(Parameter)
    String getAll(String Date){
        Node current = head;
        String temp = "";

        while (current!=null){
            if (current.getDate().equals(Date)){
                while (!current.root.isEmpty()){
                    Transaction maxTransaction = current.root.RemoveMax();
                    temp += maxTransaction.tAmt + " " + maxTransaction.tNum + " ";
                }
//                Remove the Head
                if (current == head) {
                    head = current.nextHash;
                    if (head != null)
                        head.prevHash = null;
                }
//                Removing the tail
                     else if (current == tail){
                        tail = current.prevHash;
                    if(tail != null){
                        tail.nextHash = null;
                    }
//                     Middle Node
                    }else {
                        current.prevHash.nextHash = current.nextHash;
                        current.nextHash.prevHash = current.prevHash;
                    }

                    size--;
                 return temp.trim();
                }

                current = current.nextHash;
            }
        return "-1";
    }
}
