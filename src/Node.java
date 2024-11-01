public class Node {
    public String Date;
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
        this.Date = datingDate(Date);
        this.nextHash = null;
        this.prevHash = null;
        this.root = new MaxHeap(capacity);
        this.sT = 1;
    }

    public static String datingDate(String date) {
        if (date.length() == 7) {
            return "0" + date;
        }
        return date;
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