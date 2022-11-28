package mysqljavaprj;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;



public class f2 extends JFrame {



private JPanel contentPane;
private JTextField name;
private JTextField dob;
private JTextField phoneno;
private JTextField attendance;
private JTextField department;
private JTextField subject;
private JPasswordField pass;



/**
* Launch the application.
*/
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
        f2 frame = new f2();
        frame.setVisible(true);
        } catch (Exception e) {
        e.printStackTrace();
        }
     }
    });
}



/**
* Create the frame.
*/
public f2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 680, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("NAME");
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("NAME");
        lblNewLabel_1.setForeground(new Color(25, 25, 112));
        lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(130, 71, 74, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD");
        lblNewLabel_2.setForeground(new Color(25, 25, 112));
        lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(129, 111, 115, 19);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("BIRTH DATE");
        lblNewLabel_3.setForeground(new Color(25, 25, 112));
        lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_3.setBounds(129, 164, 115, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("PHONE NO");
        lblNewLabel_4.setForeground(new Color(25, 25, 112));
        lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_4.setBounds(129, 208, 115, 35);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("ATTENDANCE");
        lblNewLabel_5.setForeground(new Color(25, 25, 112));
        lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_5.setBounds(129, 265, 115, 27);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("DEPARTMENT");
        lblNewLabel_6.setForeground(new Color(25, 25, 112));
        lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_6.setBounds(129, 320, 115, 14);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("SUBJECT");
        lblNewLabel_7.setForeground(new Color(25, 25, 112));
        lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_7.setBounds(129, 352, 115, 37);
        contentPane.add(lblNewLabel_7);

        name = new JTextField();
        name.setForeground(Color.BLUE);
        name.setBackground(Color.WHITE);
        name.setBounds(260, 70, 232, 20);
        contentPane.add(name);
        name.setColumns(10);

        dob = new JTextField();
        dob.setBounds(260, 163, 232, 20);
        contentPane.add(dob);
        dob.setColumns(10);

        phoneno = new JTextField();
        phoneno.setBounds(260, 217, 228, 20);
        contentPane.add(phoneno);
        phoneno.setColumns(10);

        attendance = new JTextField();
        attendance.setBounds(260, 270, 228, 20);
        contentPane.add(attendance);
        attendance.setColumns(10);

        department = new JTextField();
        department.setBounds(260, 319, 228, 20);
        contentPane.add(department);
        department.setColumns(10);

        subject = new JTextField();
        subject.setBounds(264, 362, 228, 20);
        contentPane.add(subject);
        subject.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(260, 112, 228, 20);
        contentPane.add(pass);

        JButton btnNewButton = new JButton("CREATE ACCOUNT");
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 23));
        btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproj?characterEncoding=latin1","root","123");
                PreparedStatement ps = conn.prepareStatement("insert into staff(name,password,dob,phoneno,attendance,department,subject) values(?,?,?,?,?,?,?);");
                ps.setString(1, name.getText());
                ps.setString(2, pass.getText());
                ps.setString(3, dob.getText());
                ps.setString(4, phoneno.getText());
                ps.setString(5, attendance.getText());
                ps.setString(6, department.getText());
                ps.setString(7, subject.getText());

        int x = ps.executeUpdate();
        if(x>0){
        System.out.println("successfully created");
        }else {
        System.out.println("create again");
        }
        }catch(Exception e1) {
        System.out.println(e1);
        }
        f1 f = new f1();
        f.setVisible(true);
        this.dispose();



}


private void dispose() {
// TODO Auto-generated method stub

}
});
btnNewButton.setBounds(111, 406, 440, 48);
contentPane.add(btnNewButton);
JLabel lblNewLabel_8 = new JLabel("ENTER YOUR DETAILS");
lblNewLabel_8.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
lblNewLabel_8.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 25));
lblNewLabel_8.setBounds(170, 11, 440, 31);
contentPane.add(lblNewLabel_8);
}
}
