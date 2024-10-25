public class Node {
  public String Date;
    Node nextHash;
    Node prevHash;
    MaxHeap root;

    Node() {
        this.Date = "";
        this.nextHash = null;
        this.prevHash = null;
        this.root = null;
        this.root = new MaxHeap();
    }

    Node(String Date) {
        this.Date = Date;
        this.nextHash = null;
        this.prevHash = null;
        this.root = new MaxHeap();
    }

    public String getDate() {
        return this.Date;
}
public void setDate(String Date) {
        this.Date = Date;
}

//NOTE:
// String toString(Date)?
    @Override
    public String toString() {
        return this.Date;
}

}