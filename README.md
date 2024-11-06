# nodeCoin

nodeCoin is a cryptocurrency project designed specifically for CS210 students to implement and understand data structures and algorithms. It demonstrates how data structures such as doubly linked lists, heaps, and nodes can be used to create a simplified cryptocurrency system.

## Features

- **nodeCoin Data Structure**: Combines linked lists and max heaps to efficiently handle transactions.
- **Insertion and Deletion**: Supports adding and removing nodes (dates) and transactions.
- **Max Transaction Retrieval**: Quickly fetches the highest transaction value for any date using a max heap.
- **Error Handling**: Gracefully manages user input errors.

## Project Structure

- **MaxHeap**: Manages transactions using a max heap for efficient retrieval of the highest transaction value.
- **Node**: Represents each unique date, which contains a `MaxHeap` of transactions for that day.
- **nodeCoin**: Manages all nodes using a doubly linked list.
- **Transaction**: Represents a transaction with an amount and transaction number.
- **Main**: The main class that ties everything together and handles user interaction.

## Usage

1. **Insert Transaction**: Add a new transaction to a date. Transactions are stored in a max heap.
   ```
   Input: 1 [date] [amount]
   Example: 1 01012023 15.0
   ```

2. **Get Maximum Transaction**: Retrieve the highest transaction for a date.
   ```
   Input: 2 [date]
   Example: 2 01012023
   ```

3. **Remove Maximum Transaction**: Remove the highest transaction for a date.
   ```
   Input: 3 [date]
   Example: 3 01012023
   ```

4. **Get All Transactions**: Retrieve and clear all transactions for a date.
   ```
   Input: 4 [date]
   Example: 4 01012023
   ```

## Big-O Runtime Analysis

| Operation                  | Best Case      | Worst Case        |
|---------------------------|----------------|-------------------|
| Insert Transaction        | O(log m)       | O(n + log m)      |
| Get Maximum Transaction   | O(n)           | O(n)              |
| Remove Maximum Transaction| O(log m)       | O(n + log m)      |
| Get All Transactions      | O(n + m * log m)| O(n + m * log m)  |

## Comparison with Other Data Structures

- **Doubly Linked List (DLL)**: A DLL alone would not efficiently manage transactions as it would require additional sorting. nodeCoin's integrated max heap allows for efficient sorting and retrieval.
- **Max Heap Alone**: A max heap alone cannot categorize transactions by date. nodeCoin combines linked lists for date management with max heaps for transactions, providing a more efficient solution.

## How to Run

1. Clone the repository.
   ```
   git clone https://github.com/RakanSuliman/NodeCoin.git
   ```
2. Compile and run the Main class using Java.
   ```
   javac Main.java
   java Main
   ```
3. Enter commands based on the usage instructions.

## Acknowledgments

- Thanks to Dr.Basit Qureshi CS210 course instructor for guiding and teaching us data structures. 


