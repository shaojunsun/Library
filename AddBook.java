import include.Message;
import model.Author;
import model.Book2;

import javax.swing.*;
import java.awt.*;

import java.util.stream.Collectors;

/**
 * Created by oaev on 10.10.16.
 */
public class AddBook extends JFrame {

    public AddBook(Library library) throws HeadlessException {
        super("Add a book");

        setBounds(120, 120, 600, 400);

        JLabel BookLabel = new JLabel("Book Name： ");
        JTextField bookNameField = new JTextField(16);

        JLabel authorsLabel = new JLabel("Author: ");

        java.util.List<String> authorsList = library.getAuthors().stream().map(Author::getName).collect(Collectors.toList());
        String[] authorsArray = authorsList.toArray(new String[0]);
        JComboBox authorsField = new JComboBox(authorsArray);

        JPanel fieldPanel = new JPanel(new FlowLayout());

        fieldPanel.add(BookLabel, BorderLayout.NORTH);
        fieldPanel.add(bookNameField);

        fieldPanel.add(authorsLabel, BorderLayout.NORTH);
        fieldPanel.add(authorsField);

        JButton addButton = new JButton("Add");
        fieldPanel.add(addButton);

        add(fieldPanel);

        addButton.addActionListener(e -> {

            String bookName = bookNameField.getText().trim();
            if (bookName.equals("")) {
                Message.showMessage(this, "Book name cannot be empty", "");

            } else {

                Book2 book = new Book2();
                book.setTitle(bookName);

                Author author = library.getAuthors().get(authorsField.getSelectedIndex());
                book.setAuthor(author);

                library.getBooks().add(book);
                library.updateLabels();
                dispose();
            }
        });
    }
}
