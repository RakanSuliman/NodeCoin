public class Transaction {
    double tAmt;
    int tNum;
    Transaction(double tAmt, int tNum) {
        this.tAmt = tAmt;
        this.tNum = tNum;
    }

    public int compareTo(Transaction t) {
        if (this.tAmt > t.tAmt) {
            return 1;
        } else if (this.tAmt < t.tAmt) {
            return -1;
        } else {
            return 0;
        }
    }
}