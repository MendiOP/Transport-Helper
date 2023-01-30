import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

    private JLabel usernameLabel, nameLabel, passwordLabel, answerLabel, questionLabel;
    private JLabel signupLabel;
    private JPanel contentPane;
    private JComboBox comboBox;

    private JTextField fieldUserName, fieldName, fieldPassword, fieldAnswer;

    private JButton buttonSubmit, buttonBack;
    public SignUp(){
        setBounds(600,250,700,406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        usernameLabel = new JLabel("Username : ");
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setBounds(100,86,92,26);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(usernameLabel);

        nameLabel = new JLabel("Name : ");
        nameLabel.setForeground(Color.DARK_GRAY);
        nameLabel.setBounds(100,125,92,26);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(nameLabel);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setBounds(100,160,92,26);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(passwordLabel);

        questionLabel = new JLabel("Security Question :");
        questionLabel.setForeground(Color.DARK_GRAY);
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        questionLabel.setBounds(99, 197, 140, 26);
        contentPane.add(questionLabel);

        answerLabel = new JLabel("Answer : ");
        answerLabel.setForeground(Color.DARK_GRAY);
        answerLabel.setBounds(100,234,92,26);
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(answerLabel);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        ImageIcon c1 = new ImageIcon("icons/singup.png");
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        signupLabel = new JLabel(i2);
        signupLabel.setBounds(460, 70,200,200);
        add(signupLabel);

        fieldUserName = new JTextField();
        fieldUserName.setBounds(265,91,148,20);
        contentPane.add(fieldUserName);
        fieldUserName.setColumns(10);

        fieldName = new JTextField();
        fieldName.setBounds(265,128,148,20);
        contentPane.add(fieldName);
        fieldName.setColumns(10);

        fieldPassword = new JTextField();
        fieldPassword.setBounds(265,165,148,20);
        contentPane.add(fieldPassword);
        fieldPassword.setColumns(10);

        fieldAnswer = new JTextField();
        fieldAnswer.setBounds(265,239,148,20);
        contentPane.add(fieldAnswer);
        fieldAnswer.setColumns(10);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(this);
        buttonSubmit.setBounds(200,289,100,30);
        buttonSubmit.setBackground(Color.BLACK);
        buttonSubmit.setForeground(Color.WHITE);
        contentPane.add(buttonSubmit);

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(this);
        buttonBack.setBounds(350,289,100,30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
                            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Connections connections = new Connections();

            if(event.getSource() == buttonSubmit){
                String username = fieldUserName.getText();
                String name = fieldName.getText();
                String password = fieldPassword.getText();
                String answer = fieldAnswer.getText();
                String question =(String) comboBox.getSelectedItem();

                String sql = "insert into accounts values('" + username +"', '" +name+ "' , '" + password + "' , '"+question+"', '"+answer+"')";
                connections.statement.executeUpdate(sql);

                this.setVisible(false);
                new Login().setVisible(true);
            }

            else if(event.getSource() == buttonBack){
                new Login().setVisible(true);
                this.setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }
}
