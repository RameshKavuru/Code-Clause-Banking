import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineBankingSystem extends JFrame {
    // Dummy database for demonstration
    // In a real-world scenario, you would use a proper database like MySQL
    // and implement data access logic accordingly
    static class Database {
        static double getBalance(String accountNumber) {
            // Dummy method to retrieve balance
            // Replace with actual database logic
            return 1000.0; // Sample balance
        }

        static void transfer(String fromAccount, String toAccount, double amount) {
            // Dummy method to perform transfer
            // Replace with actual database logic
            System.out.println("Transferred " + amount + " from " + fromAccount + " to " + toAccount);
        }
    }

    public OnlineBankingSystem() {
        setTitle("Online Banking System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // UI components
        JTextField fromAccountField = new JTextField();
        JTextField toAccountField = new JTextField();
        JTextField amountField = new JTextField();
        JButton transferButton = new JButton("Transfer");

        // Action listener for transfer button
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromAccount = fromAccountField.getText();
                String toAccount = toAccountField.getText();
                double amount = Double.parseDouble(amountField.getText());

                // Check if fromAccount has enough balance
                if (Database.getBalance(fromAccount) >= amount) {
                    Database.transfer(fromAccount, toAccount, amount);
                    JOptionPane.showMessageDialog(null, "Transfer successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                }
            }
        });

        // Add components to the frame
        add(new JLabel("From Account:"));
        add(fromAccountField);
        add(new JLabel("To Account:"));
        add(toAccountField);
        add(new JLabel("Amount:"));
        add(amountField);
        add(transferButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineBankingSystem();
            }
        });
    }
}