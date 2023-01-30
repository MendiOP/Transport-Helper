import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCustomer extends JFrame {

    String username;
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    private JPanel contentPane;

    JLabel labelImage, labelUserName, labelId, labelNumber, labelName, labelGender,labelCountry,
    labelAddress,labelPhoneNumber,labelEmail;
    JTextField fieldUserName, filedId, fieldNumber, fieldName,fieldGender,fieldCountry,fieldRoomNumber,
    fieldPhone, fieldEmail;

    public UpdateCustomer(String username) throws SQLException{
        this.username = username;

        setBounds(500,220,850,550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("icon/update.jpeg");
        Image image = imageIcon.getImage().getScaledInstance(200,400,Image.SCALE_DEFAULT);

        labelImage = new JLabel(new ImageIcon(image));
        labelImage.setBounds(118,11,300,52);
        contentPane.add(labelImage);

        labelUserName = new JLabel("Username  : ");
        labelUserName.setBounds(35,70,200,15);
        contentPane.add(labelUserName);

        fieldUserName = new JTextField();
        fieldUserName.setBounds(271,70,150,20);
        fieldUserName.setColumns(10);
        contentPane.add(fieldUserName);

        labelId = new JLabel("ID : ");
        labelId.setBounds(35,110,200,15);
        contentPane.add(labelId);

        filedId = new JTextField();
        filedId.setBounds(271,110,150,20);
        filedId.setColumns(10);
        contentPane.add(filedId);

        labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35,150,200,15);
        contentPane.add(labelNumber);

        fieldNumber = new JTextField();
        fieldNumber.setBounds(271,150,150,20);
        fieldNumber.setColumns(10);
        contentPane.add(fieldNumber);

        labelName = new JLabel("Name : ");
        labelName.setBounds(35,190,200,15);
        contentPane.add(labelName);

        fieldName = new JTextField();
        fieldName.setBounds(271,190,150,20);
        fieldName.setColumns(10);
        contentPane.add(fieldName);

        labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,230,200,15);
        contentPane.add(labelGender);

        fieldGender = new JTextField();
        fieldGender.setBounds(271,230,150,20);
        fieldGender.setColumns(10);
        contentPane.add(fieldGender);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35,270,200,15);
        contentPane.add(labelCountry);

        fieldCountry = new JTextField();
        fieldCountry.setBounds(271,270,150,20);
        fieldCountry.setColumns(10);
        contentPane.add(fieldCountry);

        labelAddress = new JLabel("Permanent Address :");
        labelAddress.setBounds(35, 310, 200, 14);
        contentPane.add(labelAddress);

        fieldRoomNumber = new JTextField();
        fieldRoomNumber.setBounds(271, 310, 150, 20);
        contentPane.add(fieldRoomNumber);
        fieldRoomNumber.setColumns(10);

        labelPhoneNumber = new JLabel("Phone :");
        labelPhoneNumber.setBounds(35, 350, 200, 14);
        contentPane.add(labelPhoneNumber);

        fieldPhone = new JTextField();
        fieldPhone.setBounds(271, 350, 150, 20);
        contentPane.add(fieldPhone);
        fieldPhone.setColumns(10);

        labelEmail = new JLabel("Email :");
        labelEmail.setBounds(35, 390, 200, 14);
        contentPane.add(labelEmail);

        fieldEmail = new JTextField();
        fieldEmail.setBounds(271, 390, 150, 20);
        contentPane.add(fieldEmail);
        fieldEmail.setColumns(10);

        try{
            Connections connections = new Connections();

            ResultSet rs = connections.statement.executeQuery("select * from customer where username = '" + username + "'");
            if(rs.next()){
                fieldUserName.setText(rs.getString(1));
                filedId.setText(rs.getString(2));
                fieldNumber.setText(rs.getString(3));
                fieldName.setText(rs.getString(4));
                fieldGender.setText(rs.getString(5));
                fieldCountry.setText(rs.getString(6));
                fieldRoomNumber.setText(rs.getString(7));
                fieldPhone.setText(rs.getString(8));
                fieldEmail.setText(rs.getString(9));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connections c = new Connections();


                try{
                    String s1 = fieldUserName.getText();
                    String s2 = filedId.getText();
                    String s3 =  fieldNumber.getText();
                    String s4 =  fieldName.getText();
                    String s5 =  fieldGender.getText();
                    String s6 =  fieldCountry.getText();
                    String s7 =  fieldRoomNumber.getText();
                    String s8 =  fieldPhone.getText();
                    String s9 = fieldEmail.getText();

                    String q1 = "update customer set id_type = '"+s2+"', number = '"+s3+"', name = '"+s4+"', gender = '"+s5+"', country = '"+s6+"', address = '"+s7+"', phone = '"+s8+"', email = '"+s9+"' where username = '"+s1+"'";
                    c.statement.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });

        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) throws SQLException{
        new UpdateCustomer("").setVisible(true);
    }
}
