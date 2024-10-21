public class MaxHeap {
    Transaction[] heap;
    int capacity;
    int currentSize;

    MaxHeap(){
        this.capacity = 10;
        this.heap = new Transaction[capacity];
        this.currentSize = 0;
    }
    MaxHeap(int capacity) {
        heap = new Transaction[capacity + 1];
        this.capacity = capacity;
        currentSize = 0;

    }
    void Swim(int k){

    }
    void Sink(int k){

    }
    void Insert(Transaction t){

    }
    Transaction RemoveMax(){
    return null;
    }
}
