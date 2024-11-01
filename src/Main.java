import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        nodeCoin nodecoin = new nodeCoin();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] splash = input.split(" ");

            if (splash.length <= 1) {
                System.out.println("-1");
                continue;
            }
            // Get user operation type and date
            int userOption = Integer.parseInt(splash[0]);
            String date = Node.datingDate(splash[1]);

            switch (userOption) {
                case 1: // Insert transaction
                    double amount = Double.parseDouble(splash[2]);
                    Node node = nodecoin.getMax(date);
                    if (node == null) {
                        node = new Node(date, 100);
                        nodecoin.insert(node);
                    }
                    int transactionNum = node.sT++;
                    node.root.Insert(new Transaction(amount, transactionNum));
                    break;

                case 2: // Get maximum transaction for a date
                    node = nodecoin.getMax(date);
                    if (node != null && !node.root.isEmpty()) {
                        Transaction maxTransaction = node.root.transaction[1];
                        System.out.println(maxTransaction.tAmt + " " + maxTransaction.tNum);
                    } else {
                        System.out.println("-1");
                    }
                    break;

                case 3: // Remove maximum transaction for a date
                    node = nodecoin.getMax(date);
                    if (node != null && !node.root.isEmpty()) {
                        node.root.RemoveMax();
                    } else {
                        System.out.println("-1");
                    }
                    break;

                case 4: // Get all transactions for a date and clear each node and return the value
                    String allTransactions = nodecoin.getAll(date);
                    System.out.println(allTransactions);
                    break;

                default: // If user enters an invalid option
                    System.out.println("-1");
                    break;
            }
        }
    }
}