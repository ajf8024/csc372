import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp extends JFrame implements ActionListener {
    private JTextField depositField, withdrawField;
    private JLabel balanceLabel;
    private double balance = 0.0;

    public BankBalanceApp() {
        setTitle("Bank Balance Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel depositLabel = new JLabel("Deposit:");
        panel.add(depositLabel);

        depositField = new JTextField();
        panel.add(depositField);

        JLabel withdrawLabel = new JLabel("Withdraw:");
        panel.add(withdrawLabel);

        withdrawField = new JTextField();
        panel.add(withdrawField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        JButton showBalanceButton = new JButton("Show Balance");
        showBalanceButton.addActionListener(this);
        panel.add(showBalanceButton);

        balanceLabel = new JLabel("Balance: ");
        panel.add(balanceLabel);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            try {
                double depositAmount = Double.parseDouble(depositField.getText());
                balance += depositAmount;
                JOptionPane.showMessageDialog(this, "Deposit Successful!");
                depositField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            try {
                double withdrawAmount = Double.parseDouble(withdrawField.getText());
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                }
                withdrawField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            }
        } else if (e.getActionCommand().equals("Show Balance")) {
            balanceLabel.setText("Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankBalanceApp app = new BankBalanceApp();
            app.setVisible(true);
        });
    }
}
