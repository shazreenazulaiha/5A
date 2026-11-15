import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddStudentInfo extends JFrame {
    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtArea;
    private ArrayList<Student> studentList;

    public AddStudentInfo(ArrayList<Student> list) {
        this.studentList = list;
        setTitle("Add Student Info");
        setSize(450, 290);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(null);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(10, 10, 100, 20);
        txtName = new JTextField();
        txtName.setBounds(220, 10, 210, 20);

        lblMatric = new JLabel("Matric:");
        lblMatric.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMatric.setBounds(10, 35, 100, 20);
        txtMatric = new JTextField();
        txtMatric.setBounds(220, 35, 210, 20);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(150, 65, 70, 25);
        btnList = new JButton("List");
        btnList.setBounds(230, 65, 70, 25);

        lblStudents = new JLabel("Students:");
        lblStudents.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStudents.setBounds(10, 105, 100, 20);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane sp = new JScrollPane(txtArea);
        sp.setBounds(10, 128, 420, 100);

        pane.add(lblName);    pane.add(txtName);
        pane.add(lblMatric);  pane.add(txtMatric);
        pane.add(btnAdd);     pane.add(btnList);
        pane.add(lblStudents); pane.add(sp);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String matric = txtMatric.getText().trim();
                if (name.equals("") || matric.equals("")) {
                    JOptionPane.showMessageDialog(AddStudentInfo.this,
                        "Please fill in name and matric.");
                    return;
                }
                studentList.add(new Student(name, matric));
                txtName.setText("");
                txtMatric.setText("");
            }
        });

        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = "";
                for (Student s : studentList) {
                    text += s.toString() + "\n";
                }
                txtArea.setText(text);
                txtName.setText("");
                txtMatric.setText("");
            }
        });
    }
}