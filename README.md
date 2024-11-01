# nodeCoin

nodeCoin is a cryptocurrency is a project for CS210 students to help them implement data structures and algorithms. It demonstrates how linked lists, heaps, and nodes can be used to create a simplified cryptocurrency system to make learning about data structures fun and practical.
## Features

- **nodeCoin Data Structure**: The primary data structure of this project, combining elements of linked lists and max heaps to efficiently handle transactions.
- **Insertion and Deletion**: Supports insertion and deletion of nodes (dates) and transactions.
- **Max Transaction Retrieval**: Quickly fetches the maximum transaction value for any given date using an internal max heap.
- **Error Handling**: Handles errors in user input gracefully, ensuring robustness during interactions.

## Project Structure

- **MaxHeap**: Handles the management of transactions by maintaining them in a max heap. This enables efficient retrieval of the highest transaction value for a given date.
- **Node**: Represents each unique date, which contains a `MaxHeap` of transactions for that specific day.
- **nodeCoin**: Represents the overarching data structure containing all nodes, effectively managing them using a doubly linked list approach.
- **Transaction**: Represents a transaction, which consists of an amount and a transaction number.
- **Solution**: The main class that ties together the various data structures and handles user interaction through command-line inputs.

## Usage

1. **Insert Transaction**: You can add a new transaction to a specific date. Transactions for a date are stored in a max heap, allowing the largest transaction to be efficiently retrieved.
   ```
   Input: 1 [date] [amount]
   Example: 1 01012023 15.0
   ```

2. **Get Maximum Transaction**: Retrieve the maximum transaction for a specific date.
   ```
   Input: 2 [date]
   Example: 2 01012023
   ```

3. **Remove Maximum Transaction**: Remove the maximum transaction for a specific date.
   ```
   Input: 3 [date]
   Example: 3 01012023
   ```

4. **Get All Transactions**: Retrieve and clear all transactions for a specific date.
   ```
   Input: 4 [date]
   Example: 4 01012023
   ```

## Big-O Runtime Analysis

| Operation                  | Best Case      | Worst Case     |
|---------------------------|----------------|----------------|
| Insert Transaction        | O(log n)       | O(log n)       |
| Get Maximum Transaction   | O(1)           | O(1)           |
| Remove Maximum Transaction| O(log n)       | O(log n)       |
| Get All Transactions      | O(n log n)     | O(n log n)     |

## Comparison with Other Data Structures

- **Doubly Linked List (DLL)**: A DLL alone would not efficiently manage transactions since each insertion would require additional sorting to maintain order. nodeCoin, with its integrated max heap, provides efficient sorting and retrieval.
- **Max Heap Alone**: A max heap alone lacks the capability to categorize transactions by date. nodeCoin uses linked lists to manage dates and max heaps to manage transactions, making it a more organized and efficient solution for our use case.

## How to Run

1. Clone the repository.
   ```
   git clone https://github.com/RakanSuliman/NodeCoin.git
   ```
2. Compile and run the Solution class using Java.
   ```
   javac Main.java
   java Main
   ```
3. Enter the commands based on the usage instructions.


## Acknowledgments

- Special thanks to Dr.Basit Qureshi course instructor for guiding and teaching us data structures.
