import model.Author;
import model.Book2;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Library extends JFrame {

    private final java.util.List<Author> authors = new ArrayList<>();
    private final java.util.List<Book2> books = new ArrayList<>();
    private final java.util.List<Student> students = new ArrayList<>();

    private final JLabel authorsLabel = new JLabel();
    private final JLabel booksLabel = new JLabel();
    private final JLabel studentsLabel = new JLabel();

    public Library() throws HeadlessException {
        super("Library management system");

        setBounds(100, 100, 600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setStudents();
        updateLabels();

        JPanel labelsPanel = new JPanel(new FlowLayout());
        labelsPanel.add(authorsLabel);
        labelsPanel.add(booksLabel);
        labelsPanel.add(studentsLabel);

        add(labelsPanel, BorderLayout.NORTH);

        JButton addAuthorsButton = new JButton("Add an author");
        JButton addBooksButton = new JButton("Add a book");
        JButton lendBookButton = new JButton("Lend a book");
        JButton showBorrowedBooks = new JButton("Show borrowed books");

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(addAuthorsButton);
        buttonsPanel.add(addBooksButton);
        buttonsPanel.add(lendBookButton);
        buttonsPanel.add(showBorrowedBooks);

        add(buttonsPanel, BorderLayout.SOUTH);

        addAuthorsButton.addActionListener(e -> {
            AddAuthor aaApp = new AddAuthor(this);

            aaApp.pack();
            aaApp.setVisible(true);
        });
        addBooksButton.addActionListener(e -> {
            AddBook baApp = new AddBook(this);

            baApp.pack();
            baApp.setVisible(true);
        });
        lendBookButton.addActionListener(e -> {
            LendBook lbApp = new LendBook(this);

            lbApp.pack();
            lbApp.setVisible(true);
        });
        showBorrowedBooks.addActionListener(e -> {
            ShowBorrowedBooks slbApp = new ShowBorrowedBooks(this);

            slbApp.pack();
            slbApp.setVisible(true);
        });
    }

    public static void main(String[] args) {

        Library app = new Library();
        app.pack();
        app.setVisible(true);
    }

    private void setStudents() {

        Student student1 = new Student("Romeo", "romeo@google.com", "123", "Student1");
        students.add(student1);

        Student student2 = new Student("Juliet", "juliet@google.com", "123", "Student2");
        students.add(student2);
    }

    public java.util.List<Author> getAuthors() {
        return authors;
    }

    public List<Book2> getBooks() {
        return books;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void updateLabels() {
        authorsLabel.setText("Authors: " + authors.size());
        booksLabel.setText("Books available: " + books.size());
        studentsLabel.setText("Students: " + students.size());
    }
}
