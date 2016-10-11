import model.Book2;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by oaev on 11.10.16.
 */
public class ShowLendedBooks extends JFrame {

    public ShowLendedBooks(Library library) throws HeadlessException {

        JPanel tablePanel = new JPanel(new BorderLayout());

        String[] headers = {
                "Student",
                "Book",
                "Author"
        };

        java.util.List<String[]> rowsList = new ArrayList<>();
        for (Student s: library.getStudents()) {
            for (Book2 book: s.getBorrowedBooks()) {

                rowsList.add(new String[] {
                        s.getUserName(),
                        book.getTitle(),
                        book.getAuthor().getName()
                });
            }
        }
        String[][] tableData = rowsList.toArray(new String[0][0]);

        JTable table = new JTable(tableData, headers);
        tablePanel.add(table);
        add(tablePanel, BorderLayout.NORTH);

        JButton closeButton = new JButton("Close");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(closeButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(e -> {
            dispose();
        });
    }
}
