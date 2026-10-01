import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentCourseManagement {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("Student Course Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> courseModel = new DefaultListModel<>();
        courseModel.addElement("Computer Science");
        courseModel.addElement("Database Systems");
        courseModel.addElement("Mathematics");
        courseModel.addElement("Operating Systems");
        JList<String> courseList = new JList<>(courseModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseList.setSelectedIndex(0);

        DefaultTableModel registrationModel = new DefaultTableModel(
                new Object[] {"Student Name", "Selected Course", "Enrollment Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable registrationTable = new JTable(registrationModel);
        registrationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTextField studentNameField = new JTextField(16);
        JButton addButton = new JButton("Add Registration");
        addButton.addActionListener(event -> {
            String studentName = studentNameField.getText().trim();
            String selectedCourse = courseList.getSelectedValue();
            if (studentName.isEmpty() || selectedCourse == null) {
                JOptionPane.showMessageDialog(frame,
                        "Enter a student name and select a course.", "Registration",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            registrationModel.addRow(new Object[] {studentName, selectedCourse, "Enrolled"});
            studentNameField.setText("");
        });

        JButton removeButton = new JButton("Remove Registration");
        removeButton.addActionListener(event -> {
            int selectedRow = registrationTable.getSelectedRow();
            if (selectedRow >= 0) {
                registrationModel.removeRow(registrationTable.convertRowIndexToModel(selectedRow));
            } else {
                JOptionPane.showMessageDialog(frame, "Select a registration to remove.",
                        "Registration", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel coursePanel = new JPanel(new BorderLayout(4, 4));
        coursePanel.add(new JLabel("Available courses"), BorderLayout.NORTH);
        coursePanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        JPanel registrationPanel = new JPanel(new BorderLayout(4, 4));
        registrationPanel.add(new JLabel("Student registrations"), BorderLayout.NORTH);
        registrationPanel.add(new JScrollPane(registrationTable), BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controls.add(new JLabel("Student name:"));
        controls.add(studentNameField);
        controls.add(addButton);
        controls.add(removeButton);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.add(coursePanel, BorderLayout.WEST);
        content.add(registrationPanel, BorderLayout.CENTER);
        content.add(controls, BorderLayout.SOUTH);
        frame.add(content);
        frame.setSize(760, 380);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentCourseManagement::createAndShowGui);
    }
}