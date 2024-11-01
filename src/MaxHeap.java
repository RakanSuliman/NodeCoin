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
        if (capacity <= 0 || capacity > 100000) {
            throw new IllegalArgumentException();
        }
        transaction = new Transaction[capacity + 1];
        this.capacity = capacity;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    void swap(int i, int j) {
        Transaction temp = transaction[i];
        transaction[i] = transaction[j];
        transaction[j] = temp;
    }

    void Swim(int k) {
        while (k > 1 && transaction[k].compareTo(transaction[k / 2]) > 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    void Sink(int k) {
        while (2 * k <= currentSize) {
            int j = 2 * k; // Left child
            if (j < currentSize && transaction[j].compareTo(transaction[j + 1]) < 0) {
                j++;
            }
            if (transaction[k].compareTo(transaction[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    void Insert(Transaction t) {
        if (currentSize >= capacity) {
            throw new IllegalStateException("Heap is full");
        }
        transaction[++currentSize] = t;
        Swim(currentSize);
    }

    Transaction RemoveMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        Transaction temp = transaction[1];
        transaction[1] = transaction[currentSize];
        transaction[currentSize] = null;
        currentSize--;
        Sink(1);
        return temp;
    }
}