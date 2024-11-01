public class MaxHeap {
    Transaction[] transaction;
    int capacity;
    int currentSize;

    MaxHeap() {
        this.capacity = 10;
        this.transaction = new Transaction[capacity];
        this.currentSize = 0;
    }

    MaxHeap(int capacity) {

        transaction = new Transaction[capacity + 1];
        this.capacity = capacity;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    }
}