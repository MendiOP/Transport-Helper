import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel labelLogin, labelUserName, labelPaswsword, labelTrouble;
    private JButton buttonLogin, buttonSignup, buttonForgotPass;

    private JTextField fieldUserName, fieldPassword;

    public Login() {
        setBackground(new Color(255, 255, 204));
        setBounds(550, 250, 700, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon c1 = new ImageIcon("icons/login.png");
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        labelLogin = new JLabel(i2);
        labelLogin.setBounds(400, 100, 200, 200);
        add(labelLogin);

        labelUserName = new JLabel("Username : ");
        labelUserName.setBounds(50, 150, 100, 20);
        labelUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelUserName);

        labelPaswsword = new JLabel("Password : ");
        labelPaswsword.setBounds(50, 200, 100, 20);
        labelPaswsword.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPaswsword);

        fieldUserName = new JTextField();
        fieldUserName.setBounds(170, 150, 150, 20);
        fieldUserName.setColumns(10);
        add(fieldUserName);

        fieldPassword = new JTextField();
        fieldPassword.setBounds(170, 200, 150, 20);
        fieldPassword.setColumns(10);
        add(fieldPassword);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(50, 240, 100, 26);
        buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonLogin.setForeground(new Color(46, 139, 87));
        buttonLogin.setBackground(new Color(176, 224, 230));
        buttonLogin.addActionListener(this);
        add(buttonLogin);

        buttonSignup = new JButton("SignUp");
        buttonSignup.setBounds(190, 240, 100, 26);
        buttonSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonSignup.setForeground(new Color(139, 69, 19));
        buttonSignup.setBackground(new Color(255, 235, 205));
        buttonSignup.addActionListener(this);
        add(buttonSignup);

        buttonForgotPass = new JButton("Forgot Password");
        buttonForgotPass.setBounds(50, 280, 240, 26);
        buttonForgotPass.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonForgotPass.setForeground(new Color(205, 92, 92));
        buttonForgotPass.setBackground(new Color(253, 245, 230));
        buttonForgotPass.addActionListener(this);
        add(buttonForgotPass);

        labelTrouble = new JLabel("Trouble in Login?");
        labelTrouble.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelTrouble.setForeground(new Color(255, 0, 0));
        labelTrouble.setBounds(100, 320, 110, 20);
        add(labelTrouble);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Login-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 40, 640, 310);
        panel.setBackground(Color.WHITE);
        add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            Connections connections = new Connections();

            Boolean status = false;
            try {
                String sql = "select * from accounts where username=? and password=?";
                PreparedStatement st = connections.connection.prepareStatement(sql);

                st.setString(1, fieldUserName.getText());
                st.setString(2, fieldPassword.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Home(fieldUserName.getText()).setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

        public static void main (String[]args){
            new Login().setVisible(true);
        }
}

