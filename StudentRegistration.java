import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentRegistration {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("Student Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(18);
        JTextField registerNumberField = new JTextField(18);
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        JComboBox<String> departmentBox = new JComboBox<>(new String[] {
                "Computer Science", "Information Technology", "Electronics", "Mechanical"
        });
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(event -> {
            String gender = maleButton.isSelected() ? "Male"
                    : femaleButton.isSelected() ? "Female"
                    : otherButton.isSelected() ? "Other" : "Not selected";
            String message = "Name: " + nameField.getText().trim()
                    + "\nRegister number: " + registerNumberField.getText().trim()
                    + "\nGender: " + gender
                    + "\nDepartment: " + departmentBox.getSelectedItem();
            JOptionPane.showMessageDialog(frame, message, "Registration Details",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.add(new JLabel("Student name:"));
        form.add(nameField);
        form.add(new JLabel("Register number:"));
        form.add(registerNumberField);
        form.add(new JLabel("Gender:"));
        form.add(genderPanel);
        form.add(new JLabel("Department:"));
        form.add(departmentBox);
        form.add(new JLabel());
        form.add(submitButton);

        frame.add(form);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistration::createAndShowGui);
    }
}