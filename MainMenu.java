import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private JButton btnAddStudent, btnAddBook, btnBorrowBook;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public MainMenu() {
        setTitle("Main Menu");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JLabel lblTitle = new JLabel("~ BORROW BOOK SYSTEM ~", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        Dimension btnSize = new Dimension(220, 35);
        btnAddStudent.setPreferredSize(btnSize);
        btnAddBook.setPreferredSize(btnSize);
        btnBorrowBook.setPreferredSize(btnSize);

        add(lblTitle);
        add(btnAddStudent);
        add(btnAddBook);
        add(btnBorrowBook);

        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddStudentInfo(MainMenu.this.studentList).setVisible(true);
            }
        });

        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddBookInfo(MainMenu.this.bookList).setVisible(true);
            }
        });

        btnBorrowBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BorrowBookInfo(MainMenu.this.studentList, MainMenu.this.bookList).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }
}