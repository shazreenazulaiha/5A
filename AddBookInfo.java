import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookInfo extends JFrame {
    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;
    private ArrayList<Book> bookList;

    public AddBookInfo(ArrayList<Book> list) {
        this.bookList = list;
        setTitle("Add Book Info");
        setSize(450, 290);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(null);

        lblTitle = new JLabel("Book Title:");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTitle.setBounds(10, 10, 100, 20);
        txtTitle = new JTextField();
        txtTitle.setBounds(220, 10, 210, 20);

        lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblAuthor.setBounds(10, 35, 100, 20);
        txtAuthor = new JTextField();
        txtAuthor.setBounds(220, 35, 210, 20);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(150, 65, 70, 25);
        btnList = new JButton("List");
        btnList.setBounds(230, 65, 70, 25);

        lblBooks = new JLabel("Books:");
        lblBooks.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBooks.setBounds(10, 105, 100, 20);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane sp = new JScrollPane(txtArea);
        sp.setBounds(10, 128, 420, 100);

        pane.add(lblTitle);  pane.add(txtTitle);
        pane.add(lblAuthor); pane.add(txtAuthor);
        pane.add(btnAdd);    pane.add(btnList);
        pane.add(lblBooks);  pane.add(sp);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText().trim();
                String author = txtAuthor.getText().trim();
                if (title.equals("") || author.equals("")) {
                    JOptionPane.showMessageDialog(AddBookInfo.this,
                        "Please fill in book title and author.");
                    return;
                }
                bookList.add(new Book(title, author));
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        });

        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = "";
                for (Book b : bookList) {
                    text += b.toString() + "\n";
                }
                txtArea.setText(text);
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        });
    }
}