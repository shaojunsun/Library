import include.Message;
import model.Author;

import javax.swing.*;
import java.awt.*;

/**
 * Created by oaev on 10.10.16.
 */
public class AddAuthor extends JFrame {

    public AddAuthor(Library library) throws HeadlessException {
        super("Add an author");

        setBounds(120, 120, 600, 400);

        JLabel authorLabel = new JLabel("Author Name： ");
        JTextField authorField = new JTextField(16);
        JPanel fieldPanel = new JPanel(new FlowLayout());

        fieldPanel.add(authorLabel, BorderLayout.NORTH);
        fieldPanel.add(authorField);

        JButton addButton = new JButton("Add");
        fieldPanel.add(addButton);

        add(fieldPanel);

        addButton.addActionListener(e -> {

            String authorName = authorField.getText().trim();
            if (authorName.equals("")) {
                Message.showMessage(this, "Author name cannot be empty", "");

            } else {

                Author author = new Author();
                author.setName(authorName);

                library.getAuthors().add(author);
                library.updateLabels();
                dispose();
            }
        });
    }
}
