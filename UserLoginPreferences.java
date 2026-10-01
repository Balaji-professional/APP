import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserLoginPreferences {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField usernameField = new JTextField(18);
        JPasswordField passwordField = new JPasswordField(18);
        JCheckBox rememberMeBox = new JCheckBox("Remember Me");
        JCheckBox notificationsBox = new JCheckBox("Receive Notifications");
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(event -> {
            String username = usernameField.getText().trim();
            char[] password = passwordField.getPassword();
            if (username.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(frame, "Enter both username and password.",
                        "Login", JOptionPane.WARNING_MESSAGE);
            } else {
                String message = "Login form submitted for " + username
                        + ".\nRemember Me: " + (rememberMeBox.isSelected() ? "Yes" : "No")
                        + "\nReceive Notifications: "
                        + (notificationsBox.isSelected() ? "Yes" : "No");
                JOptionPane.showMessageDialog(frame, message, "Login",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            java.util.Arrays.fill(password, '\0');
            passwordField.setText("");
        });

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);
        form.add(rememberMeBox);
        form.add(notificationsBox);
        form.add(new JLabel());
        form.add(loginButton);

        frame.add(form);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLoginPreferences::createAndShowGui);
    }
}