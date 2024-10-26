import java.util.Scanner;
public class Solution{
    class MaxHeap {
        Transaction[] transaction;
        int capacity;
        int currentSize;

        MaxHeap(){
            this.capacity = 10;
            this.transaction = new Transaction[capacity];
            this.currentSize = 0;
        }
        MaxHeap(int capacity) {
            if(capacity <= 0 || capacity > 100000)
                throw new IllegalArgumentException();

            transaction = new Transaction[capacity + 1];
            this.capacity = capacity;
            currentSize = 0;

        }
        public boolean isEmpty(){
            return currentSize == 0;
        }
        void swap(int i, int j){
            Transaction temp = transaction[i];
            transaction[i] = transaction[j];
            transaction[j] = temp;
        }

        void Swim(int k){
/*
This method compare the value at index k with its parent. If the value is greater than the parent, it swaps them
and moves the value up until the max-heap property is restored.
 */

            while(k>1&& transaction[k].compareTo(transaction[k/2])>0){
                swap(k,k/2);
                k = k/2;
            }
        }
        void Sink(int k){
            while(2*k <= currentSize){
                int j = 2*k; // Left child
                if (j < currentSize && transaction[j].compareTo(transaction[j+1]) < 0){
                    j++;
                }
                if (transaction[k].compareTo(transaction[j]) >= 0){
                    break;
                }
                swap(k, j);
                k = j;
            }
        }
        void Insert(Transaction t){
            if(currentSize >= capacity){
                throw new IllegalStateException("Heap is full");
            }
            transaction[++currentSize] = t;
            Swim(currentSize);
        }
        Transaction RemoveMax(){
            if(isEmpty()){
                throw new IllegalStateException("Heap is empty");
            }
            Transaction temp = transaction[1]; // Saving the max root
            transaction[1] = transaction[currentSize]; // Replace the last with the max and reduce the heap by 1
            transaction[currentSize] = null;
            currentSize--;
            Sink(1); // Sink the new root
            return temp;
        }
    }

    class Node {
        public String Date;
        Node nextHash;
        Node prevHash;
        MaxHeap root;

        Node() {
            this.Date = "";
            this.nextHash = null;
            this.prevHash = null;
            this.root = new MaxHeap();
        }

        Node(String Date, int capacity) {
            this.Date = Date;
            this.nextHash = null;
            this.prevHash = null;
            this.root = new MaxHeap(capacity);
        }


        public String getDate() {
            return this.Date;
        }
        public void setDate(String Date) {
            this.Date = Date;
        }


        @Override
        public String toString() {
            return this.Date;
        }

    }


    class nodeCoin  {
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

        Node getMax(String Date){
            if (isEmpty()){
                return null;
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
    class Transaction {
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        nodeCoin blockchain = solution.new nodeCoin();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1: // Insert transaction
                    String date = tokens[1];
                    double amount = Double.parseDouble(tokens[2]);
                    Node node = blockchain.getMax(date);
                    if (node == null) {
                        node = solution.new Node(date, 100);
                        blockchain.insert(node);
                    }
                    int transactionNum = node.root.currentSize + 1;
                    node.root.Insert(solution.new Transaction(amount, transactionNum));
                    break;

                case 2: // Get maximum transaction for a date
                    date = tokens[1];
                    node = blockchain.getMax(date);
                    if (node != null && !node.root.isEmpty()) {
                        Transaction maxTransaction = node.root.transaction[1];
                        System.out.printf("%.1f %d%n", maxTransaction.tAmt, maxTransaction.tNum);
                    } else {
                        System.out.println("-1");
                    }
                    break;

                case 3: // Remove maximum transaction for a date
                    date = tokens[1];
                    node = blockchain.getMax(date);
                    if (node != null && !node.root.isEmpty()) {
                        node.root.RemoveMax();
                    } else {
                        System.out.println("-1");
                    }
                    break;

                case 4: // Get all transactions for a date and clear node
                    date = tokens[1];
                    String allTransactions = blockchain.getAll(date);
                    System.out.println(allTransactions.equals("-1") ? "-1" : allTransactions);
                    break;

                default:
                    System.out.println("-1");
                    break;
            }
        }
        scanner.close();
    }
}