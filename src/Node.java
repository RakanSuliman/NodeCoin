public class Node {

    Node nextHash;
    Node prevHash;
    MaxHeap root;
    int sT;

    Node() {
        this.Date = "";
        this.nextHash = null;
        this.prevHash = null;
        this.root = new MaxHeap();
        this.sT = 1;
    }

    Node(String Date, int capacity) {

    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String Date) {
        this.Date = datingDate(Date);
    }


    @Override
    public String toString() {
        return this.Date;
    }
}
