import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BorrowBookInfo extends JFrame {
    private JLabel lblStudent, lblBook, lblInfoTitle, lblInfo;
    private JComboBox cmbStudent, cmbBook;
    private JButton btnBorrow;
    private ArrayList<Student> studentList;
    private ArrayList<Book> bookList;

    public BorrowBookInfo(ArrayList<Student> students, ArrayList<Book> books) {
        this.studentList = students;
        this.bookList = books;
        setTitle("Borrow Book");
        setSize(500, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(null);

        lblStudent = new JLabel("Student Name & Matric:");
        lblStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStudent.setBounds(10, 10, 180, 20);
        cmbStudent = new JComboBox();
        cmbStudent.setBounds(220, 10, 250, 22);
        for (Student s : studentList) cmbStudent.addItem(s.getInfo());

        lblBook = new JLabel("Book Title & Author:");
        lblBook.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBook.setBounds(10, 38, 180, 20);
        cmbBook = new JComboBox();
        cmbBook.setBounds(220, 38, 250, 22);
        for (Book b : bookList) cmbBook.addItem(b.getInfo());

        btnBorrow = new JButton("Borrow");
        btnBorrow.setBounds(200, 70, 80, 25);

        lblInfoTitle = new JLabel("Borrow Information :");
        lblInfoTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInfoTitle.setBounds(10, 175, 200, 20);
        lblInfo = new JLabel("");
        lblInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblInfo.setBounds(10, 195, 470, 20);

        pane.add(lblStudent); pane.add(cmbStudent);
        pane.add(lblBook);    pane.add(cmbBook);
        pane.add(btnBorrow);
        pane.add(lblInfoTitle); pane.add(lblInfo);

        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int si = cmbStudent.getSelectedIndex();
                int bi = cmbBook.getSelectedIndex();
                if (si < 0 || bi < 0) {
                    JOptionPane.showMessageDialog(BorrowBookInfo.this,
                        "Please add student and book info first.");
                    return;
                }
                Student s = studentList.get(si);
                Book b = bookList.get(bi);
                if (b.borrowBy(s)) {
                    lblInfo.setText(s.getName() + " with matric number " + s.getMatric()
                        + " has borrow a book with title " + b.getTitle() + ".");
                } else {
                    JOptionPane.showMessageDialog(BorrowBookInfo.this,
                        "Borrow failed: the book is already borrowed, "
                        + "or this student already borrowed a book.");
                }
            }
        });
    }
}