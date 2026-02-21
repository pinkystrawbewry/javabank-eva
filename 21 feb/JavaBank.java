import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaBank extends JFrame {

    private static final long serialVersionUID = 1L;

    // ===== EVA COLORS =====
    private final Color evaRed   = Color.decode("#B11226");
    private final Color evaBlack = Color.decode("#1A1A1F");

    private JPanel inputDetailJPanel;

    private JLabel NameJLabel;
    private JTextField NameJTextField;

    private JLabel AccountnumJLabel;
    private JTextField AccountnumJTextField;

    private JLabel BalanceJLabel;
    private JTextField BalanceJTextField;

    private JLabel DepositJLabel;
    private JTextField DepositJTextField;

    private JLabel WithdrawJLabel;
    private JTextField WithdrawJTextField;

    private JButton CreateAccountJButton;
    private JButton DeleteAccountJButton;
    private JButton TransactionJButton;
    private JButton DisplayJButton;

    private JLabel displayJLabel;
    private JTextArea displayJTextArea;

    public final static int MaxAccounts = 10;

    static Account myAccounts[]  = new Account[MaxAccounts];
    static int noAccounts = 0;

    // ================= CONSTRUCTOR =================
    public JavaBank() {

        createUserInterface();
        applyEVATheme();

        // ===== DEFAULT ACCOUNTS =====
        myAccounts[0] = new Account("Sanjay Gupta", 11556, 300);
        myAccounts[1] = new Account("EVA", 11557, 450);
        myAccounts[2] = new Account("Zoro", 11558, 800);
        myAccounts[3] = new Account("Asuka Langley", 11559, 1200);
        myAccounts[4] = new Account("Shinji Ikari", 11560, 950);
        myAccounts[5] = new Account("Rei Ayanami", 11561, 700);
        myAccounts[6] = new Account("Misato Katsuragi", 11562, 1500);
        myAccounts[7] = new Account("Ritsuko Akagi", 11563, 2000);
        myAccounts[8] = new Account("Gendo Ikari", 11564, 5000);
        myAccounts[9] = new Account("Kaworu Nagisa", 11565, 1750);

        noAccounts = 10;

        displayAllAccounts();
    }

    // ================= DISPLAY METHOD =================
    private void displayAllAccounts() {

        displayJTextArea.setText("Bank Name : JavaBank\n\n");

        for (int i = 0; i < noAccounts; i++) {
            displayJTextArea.append(
                    "Account Holder : " + myAccounts[i].getaccountname() + "\n" +
                    "Account Number : " + myAccounts[i].getaccountnum() + "\n" +
                    "Account Balance : " + myAccounts[i].getbalance() + "\n\n"
            );
        }
    }

    // ================= EVA THEME =================
    private void applyEVATheme() {

        getContentPane().setBackground(evaBlack);

        inputDetailJPanel.setBackground(evaBlack);
        inputDetailJPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(evaRed),
                "Input Details",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                evaRed));

        displayJLabel.setForeground(evaRed);

        displayJTextArea.setBackground(evaBlack);
        displayJTextArea.setForeground(Color.WHITE);
        displayJTextArea.setCaretColor(evaRed);

        JButton[] buttons = {
                CreateAccountJButton,
                DeleteAccountJButton,
                TransactionJButton,
                DisplayJButton
        };

        for (JButton btn : buttons) {
            btn.setBackground(evaRed);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
        }

        JLabel[] labels = {
                NameJLabel,
                AccountnumJLabel,
                BalanceJLabel,
                DepositJLabel,
                WithdrawJLabel
        };

        for (JLabel lbl : labels) {
            lbl.setForeground(Color.WHITE);
        }

        JTextField[] fields = {
                NameJTextField,
                AccountnumJTextField,
                BalanceJTextField,
                DepositJTextField,
                WithdrawJTextField
        };

        for (JTextField field : fields) {
            field.setBackground(evaBlack);
            field.setForeground(Color.WHITE);
            field.setCaretColor(evaRed);
            field.setBorder(BorderFactory.createLineBorder(evaRed));
        }
    }

    // ================= UI SETUP =================
    private void createUserInterface() {

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(16, 16, 208, 250);
        inputDetailJPanel.setLayout(null);
        contentPane.add(inputDetailJPanel);

        NameJLabel = new JLabel("Name:");
        NameJLabel.setBounds(8, 32, 90, 23);
        inputDetailJPanel.add(NameJLabel);

        NameJTextField = new JTextField();
        NameJTextField.setBounds(112, 32, 80, 21);
        inputDetailJPanel.add(NameJTextField);

        AccountnumJLabel = new JLabel("Account Number:");
        AccountnumJLabel.setBounds(8, 56, 100, 23);
        inputDetailJPanel.add(AccountnumJLabel);

        AccountnumJTextField = new JTextField();
        AccountnumJTextField.setBounds(112, 56, 80, 21);
        inputDetailJPanel.add(AccountnumJTextField);

        BalanceJLabel = new JLabel("Balance:");
        BalanceJLabel.setBounds(8, 80, 60, 23);
        inputDetailJPanel.add(BalanceJLabel);

        BalanceJTextField = new JTextField();
        BalanceJTextField.setBounds(112, 80, 80, 21);
        inputDetailJPanel.add(BalanceJTextField);

        DepositJLabel = new JLabel("Deposit:");
        DepositJLabel.setBounds(8, 104, 80, 23);
        inputDetailJPanel.add(DepositJLabel);

        DepositJTextField = new JTextField();
        DepositJTextField.setBounds(112, 104, 80, 21);
        inputDetailJPanel.add(DepositJTextField);

        WithdrawJLabel = new JLabel("Withdraw:");
        WithdrawJLabel.setBounds(8, 128, 80, 23);
        inputDetailJPanel.add(WithdrawJLabel);

        WithdrawJTextField = new JTextField();
        WithdrawJTextField.setBounds(112, 128, 80, 21);
        inputDetailJPanel.add(WithdrawJTextField);

        CreateAccountJButton = new JButton("Create");
        CreateAccountJButton.setBounds(112, 152, 80, 24);
        inputDetailJPanel.add(CreateAccountJButton);

        DeleteAccountJButton = new JButton("Delete");
        DeleteAccountJButton.setBounds(16, 152, 80, 24);
        inputDetailJPanel.add(DeleteAccountJButton);

        TransactionJButton = new JButton("Transaction");
        TransactionJButton.setBounds(16, 180, 176, 24);
        inputDetailJPanel.add(TransactionJButton);

        DisplayJButton = new JButton("Display");
        DisplayJButton.setBounds(16, 208, 176, 24);
        inputDetailJPanel.add(DisplayJButton);

        displayJLabel = new JLabel("Account Details:");
        displayJLabel.setBounds(240, 16, 150, 23);
        contentPane.add(displayJLabel);

        displayJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240,48,402,184);
        contentPane.add(scrollPane);

        setTitle("Java Bank - EVA 02");
        setSize(670, 308);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JavaBank();
    }
}