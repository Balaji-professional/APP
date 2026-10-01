import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextEditor {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(24, 80);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(event -> textArea.setText(""));
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(event -> textArea.setText(""));
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> frame.dispose());
        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(event -> textArea.cut());
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(event -> textArea.copy());
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(event -> textArea.paste());
        JMenuItem selectAllItem = new JMenuItem("Select All");
        selectAllItem.addActionListener(event -> textArea.selectAll());
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(selectAllItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        frame.setJMenuBar(menuBar);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditor::createAndShowGui);
    }
}