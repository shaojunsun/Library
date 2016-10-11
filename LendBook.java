import include.Message;
import model.Author;
import model.Book2;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

/**
 * Created by oaev on 10.10.16.
 */
public class LendBook extends JFrame {

    public LendBook(Library library) throws HeadlessException {
        super("Lend a book");

        setBounds(120, 120, 600, 400);


        JLabel booksLabel = new JLabel("Book: ");

        java.util.List<String> booksList = library.getBooks().stream().map(Book2::getTitle).collect(Collectors.toList());
        String[] booksArray = booksList.toArray(new String[0]);
        JComboBox booksField = new JComboBox(booksArray);

        JLabel studentsLabel = new JLabel("Student: ");

        java.util.List<String> studentsList = library.getStudents().stream().map(Student::getUserName).collect(Collectors.toList());
        String[] studentsArray = studentsList.toArray(new String[0]);
        JComboBox studentsField = new JComboBox(studentsArray);

        JPanel fieldPanel = new JPanel(new FlowLayout());

        fieldPanel.add(booksLabel, BorderLayout.NORTH);
        fieldPanel.add(booksField);
        fieldPanel.add(studentsLabel, BorderLayout.NORTH);
        fieldPanel.add(studentsField);

        JButton addButton = new JButton("Lend");
        JButton closeButton = new JButton("Close");
        fieldPanel.add(addButton);
        fieldPanel.add(closeButton);

        add(fieldPanel);

        addButton.addActionListener(e -> {

            if (library.getBooks().size() == 0) {

                Message.showMessage(this, "There is no books for lending", "");

            } else {

                Student student = library.getStudents().get(studentsField.getSelectedIndex());
                Book2 book = library.getBooks().get(booksField.getSelectedIndex());

                student.borrowBook(book);
                library.getBooks().remove(book);

                library.updateLabels();
                dispose();
            }
        });
        closeButton.addActionListener(e -> {
            dispose();
        });
    }
}
