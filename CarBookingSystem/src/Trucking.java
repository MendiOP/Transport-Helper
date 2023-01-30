import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Trucking extends JFrame {
    private String username;

    private JLabel labelReservationDetails, labelEmpty, labelSource, labelDestination, labelName;
    private Choice choiceSource, choiceDestination,c3;
    private JButton show,b1,b2;

    public Trucking(String username){
        this.username = username;

        setTitle("Transport Items");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocation(450,220);
        setLayout(null);

        labelReservationDetails = new JLabel("Transport Goods");
        labelReservationDetails.setForeground(Color.BLUE);
        labelReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
        labelReservationDetails.setBounds(280, 27, 359, 31);
        add(labelReservationDetails);

        labelSource = new JLabel("Source");
        labelSource.setBounds(60,100,100,27);
        labelSource.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelSource);

        labelDestination = new JLabel("Destination");
        labelDestination.setBounds(350,100,150,27);
        labelDestination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelDestination);

        labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 19));
        labelName.setBounds(50, 150, 250, 27);
        add(labelName);

        labelEmpty = new JLabel("");
        labelEmpty.setBounds(200,150,150,28);

        choiceSource = new Choice();
        choiceSource.setBounds(180,100,150,27);
        add(choiceSource);

        choiceDestination = new Choice();
        choiceDestination.setBounds(500,100,150,27);
        add(choiceDestination);

        try{
            Connections connections = new Connections();
            ResultSet rs = connections.statement.executeQuery("select * from transport");
            while(rs.next()){
                choiceSource.add(rs.getString("source"));
                choiceDestination.add(rs.getString("destination"));
            }

            rs = connections.statement.executeQuery("select * from customer where username = '"+ username+"'");
            labelEmpty.setText(rs.getString("name"));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel l11 = new JLabel("Weight : ");
        l11.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l11.setBounds(50, 200, 150, 27);
        add(l11);

        c3 = new Choice();
        c3.add("0 - 10 KG");
        c3.add("10 - 50 KG");
        c3.add("50 - 100 KG");
        c3.add("100 - 500 KG");
        c3.add("500 - 1000 KG");
        c3.add(" > 1000 KG");
        c3.setBounds(200, 200, 150, 27);
        add(c3);

        show = new JButton("SHOW DETAILS");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(400, 200, 130, 25);
        add(show);


        JLabel l1 = new JLabel("Driver Name : ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l1.setBounds(50, 250, 150, 27);
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l2.setBounds(200, 250, 150, 27);
        add(l2);

        JLabel l5 = new JLabel("Truck : ");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l5.setBounds(50, 300, 250, 27);
        add(l5);

        JLabel l6 = new JLabel("");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l6.setBounds(200, 300, 350, 27);
        add(l6);

        JLabel l7 = new JLabel("Distance : ");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l7.setBounds(50, 350, 150, 27);
        add(l7);

        JLabel l8 = new JLabel("");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l8.setBounds(200, 350, 350, 27);
        add(l8);

        JLabel l3 = new JLabel("Price : ");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l3.setBounds(50, 400, 150, 27);
        add(l3);

        JLabel l4 = new JLabel("");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        l4.setBounds(200, 400, 150, 27);
        add(l4);


        ImageIcon i1 = new ImageIcon("icons/transport.jpeg");
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l16 = new JLabel(i3);
        l16.setBounds(460, 170, 500, 300);
        add(l16);


        show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String dst  = choiceDestination.getSelectedItem();
                    String weight  = c3.getSelectedItem();

                    Connections c = new Connections();

                    String str = "select * from transport where destination = '"+dst+"'";
                    ResultSet rs = c.statement.executeQuery(str);
                    int price = 0;
                    while(rs.next()){
                        l2.setText(rs.getString("dname"));
                        price = Integer.parseInt(rs.getString("price"));
                        l6.setText(rs.getString("truck"));
                        l8.setText(rs.getString("distance"));
                    }
                    switch(weight){
                        case "0 - 10 KG" : price += 100;
                            break;
                        case "10 - 50 KG" : price += 200;
                            break;
                        case "50 - 100 KG" : price += 300;
                            break;
                        case "100 - 500 KG" : price += 400;
                            break;
                        case "500 - 1000 KG" : price += 500;
                            break;
                        case "> 1000 KG" : price += 600;
                            break;
                    }

                    l4.setText("Taka: " + price);


                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        b1 = new JButton("Transport");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 500, 150, 30);
        add(b1);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String src  = choiceSource.getSelectedItem();
                    String dst  = choiceDestination.getSelectedItem();
                    String weight  = c3.getSelectedItem();
                    String dname = l2.getText();
                    String price = l4.getText();
                    String truck = l6.getText();
                    String distance = l8.getText();
                    String name = labelEmpty.getText();

                    Connections c = new Connections();

                    c.statement.executeUpdate("delete from intransport");

                    String str = "insert into intransport values('"+username+"','"+dname+"','"+src+"','"+dst+"','"+truck+"','"+weight+"','"+distance+"','"+price+"')";
                    c.statement.executeUpdate(str);

                    JOptionPane.showMessageDialog(null, "Booked Successfully");
                    setVisible(false);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 500, 150, 30);
        add(b2);

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Trucking("").setVisible(true);
    }
}
