package mysqljavaprj;

import java.sql.*;



import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;



public class f1 extends JFrame {



    private JPanel contentPane;
    private JTextField name;
    private JPasswordField pass;



/**
* Launch the application.
*/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
            f1 frame = new f1();
            frame.setVisible(true);
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
    }
    });
    }



/**
* Create the frame.
*/
    public f1() {
        setForeground(Color.PINK);
        setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 16));
        setType(Type.UTILITY);
        setTitle("STAFF LOG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("NAME");
        lblNewLabel.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel.setForeground(new Color(75, 0, 130));
        lblNewLabel.setBounds(34, 88, 87, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setForeground(new Color(75, 0, 130));
        lblNewLabel_1.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1.setBounds(34, 145, 109, 26);
        contentPane.add(lblNewLabel_1);

        name = new JTextField();
        name.setBounds(175, 92, 230, 19);
        contentPane.add(name);
        name.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(175, 149, 230, 19);
        contentPane.add(pass);

        JButton btnNewButton = new JButton("CREATE");
        btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        btnNewButton.setBounds(34, 222, 123, 32);
        btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        f2 f =new f2();
        f.setVisible(true);
        this.dispose();

    }



    private void dispose() {
    // TODO Auto-generated method stub

    }
    });
    contentPane.add(btnNewButton);

    JButton btnNewButton_1 = new JButton("LOGIN");
    btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
    btnNewButton_1.setBounds(265, 222, 116, 32);
    btnNewButton_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    String s1=name.getText();
    String s2=pass.getText();
    Accountdetails1 a = new Accountdetails1();
    boolean flag = false;
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj?characterEncoding=latin1","root","123");
    Statement stmt=con.createStatement();
    String query="select name,password from staff where name='"+s1+"' and password='"+s2+"'";
    ResultSet rs=stmt.executeQuery(query);
    if(rs.next())
    {
    flag = true;
        JOptionPane.showMessageDialog(null,"valid user");
        Accountdetails1 t=new Accountdetails1();
        t.setVisible(true);
        this.dispose();
        String query1="select name,password,dob,phoneno,attendance,department,subject from staff where name='"+s1+"' and password='"+s2+"'";
        ResultSet rs1=stmt.executeQuery(query1);
        while(rs1.next())
        {
                System.out.println(rs1.getString(1));
                Accountdetails1.name.setText(rs1.getString(1));
                System.out.println(rs1.getString(2));
                Accountdetails1.pass.setText(rs1.getString(2));
                System.out.println(rs1.getString(3));
                Accountdetails1.dob.setText(rs1.getString(3));
                System.out.println(rs1.getString(4));
                Accountdetails1.phoneno.setText(rs1.getString(4));
                System.out.println(rs1.getString(5));
                Accountdetails1.attendance.setText(rs1.getString(5));
                System.out.println(rs1.getString(6));
                Accountdetails1.department.setText(rs1.getString(6));
                System.out.println(rs1.getString(7));
                Accountdetails1.subject.setText(rs1.getString(7));

        }
    }

    else
    {
    JOptionPane.showMessageDialog(null,"invalid user");
    }
    }
     }
    private void dispose() {
    // TODO Auto-generated method stub

     }
    });
    contentPane.add(btnNewButton_1);
    JLabel lblNewLabel_2 = new JLabel("LOGIN PAGE");
    lblNewLabel_2.setForeground(new Color(128, 0, 128));
    lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 32));
    lblNewLabel_2.setBounds(93, 11, 249, 40);
    contentPane.add(lblNewLabel_2);
    }
    }
