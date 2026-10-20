import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AddressBookGUI extends JFrame {

    private AddressBook book = new AddressBook();
    private JList<BuddyInfo> list = new JList<>(book);

    public AddressBookGUI() {
        super("Address Book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);

        add(new JScrollPane(list), BorderLayout.CENTER);
        setJMenuBar(buildMenuBar());
    }

    private JMenuBar buildMenuBar() {
        JMenuBar bar = new JMenuBar();

        // ---- AddressBook menu ----
        JMenu bookMenu = new JMenu("AddressBook");

        JMenuItem newBook = new JMenuItem("New AddressBook");
        newBook.addActionListener(e -> book.clear());
        bookMenu.add(newBook);

        JMenuItem saveBook = new JMenuItem("Save AddressBook");
        saveBook.addActionListener(e -> saveBook());
        bookMenu.add(saveBook);

        // ---- BuddyInfo menu ----
        JMenu buddyMenu = new JMenu("BuddyInfo");

        JMenuItem addBuddy = new JMenuItem("Add BuddyInfo");
        addBuddy.addActionListener(e -> addBuddy());
        buddyMenu.add(addBuddy);

        JMenuItem removeBuddy = new JMenuItem("Remove BuddyInfo");
        removeBuddy.addActionListener(e -> removeBuddy());
        buddyMenu.add(removeBuddy);

        bar.add(bookMenu);
        bar.add(buddyMenu);
        return bar;
    }

    private void addBuddy() {
        JTextField nameField    = new JTextField();
        JTextField addressField = new JTextField();
        JTextField numberField  = new JTextField();
        Object[] msg = {
                "Name:",    nameField,
                "Address:", addressField,
                "Number:",  numberField
        };
        int ok = JOptionPane.showConfirmDialog(this, msg,
                "Add BuddyInfo", JOptionPane.OK_CANCEL_OPTION);
        if (ok != JOptionPane.OK_OPTION) return;

        try {
            int number = Integer.parseInt(numberField.getText().trim());
            book.addBuddy(new BuddyInfo(
                    nameField.getText().trim(),
                    addressField.getText().trim(),
                    number));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Number must be an integer.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeBuddy() {
        BuddyInfo selected = list.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this,
                    "Select a BuddyInfo to remove.", "Nothing selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        book.removeBuddy(selected);
    }

    private void saveBook() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        try (PrintWriter out = new PrintWriter(chooser.getSelectedFile())) {
            for (int i = 0; i < book.size(); i++) {
                BuddyInfo b = book.get(i);
                out.println(b.getName() + "|" + b.getAddress() + "|" + b.getNumber());
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Could not save file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new AddressBookGUI().setVisible(true));
    }
}