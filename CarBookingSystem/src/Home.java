import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {


    JMenuBar menuBar;
    String username;
    JMenu menuCustomer, menuIntracityCab, menuIntercityCab, menuTransport, menuBill, menuPayment;
    JMenu menuUtility, menuAbout;
    JMenuItem addCustomer,updateCustomer,viewCustomer,deleteCustomer,bookcab,viewbookcab,viewCabs,
            bookCab,about,viewIntercityBookCab,bookpackage,viewBookedPackage,checkBill,pay,notepad,calculator;

    public Home(String username){
        this.username = username;

        setTitle("Home");
        ImageIcon icon = new ImageIcon("icons/mainicon.jpg");
        Image i = icon.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT);
        setIconImage(i);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(new Color(240,155,123));
        setBounds(300, 200, 800, 600);
        setLayout(null);

        JLabel label = new JLabel("Munnaa Transport");
        label.setBounds(200,200,500,50);
        label.setFont(new Font("TAHOMA", Font.BOLD, 35));
        add(label);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuCustomer = new JMenu("Customer");
        menuCustomer.setForeground(Color.BLUE);
        menuBar.add(menuCustomer);

        addCustomer = new JMenuItem("ADD CUSTOMER");
        addCustomer.addActionListener(this);
        menuCustomer.add(addCustomer);

        updateCustomer = new JMenuItem("UPDATE CUSTOMER DETAIL");
        updateCustomer.addActionListener(this);
        menuCustomer.add(updateCustomer);

        viewCustomer = new JMenuItem("VIEW CUSTOMER DETAIL");
        viewCustomer.addActionListener(this);
        menuCustomer.add(viewCustomer);

        deleteCustomer = new JMenuItem("DELETE CUSTOMER DETAIL");
        viewCustomer.addActionListener(this);
        menuCustomer.add(deleteCustomer);

        menuIntracityCab = new JMenu("BOOK INTERCITY CAB");
        menuIntracityCab.setForeground(Color.RED);
        menuBar.add(menuIntracityCab);

        bookcab = new JMenuItem("BOOK CAB");
        menuIntracityCab.add(bookcab);
        bookcab.addActionListener(this);

        viewbookcab = new JMenuItem("VIEW BOOKED CAB");
        menuIntracityCab.add(viewbookcab);
        viewbookcab.addActionListener(this);

        menuIntercityCab = new JMenu("BOOK INTERCITY CAB");
        menuIntercityCab.setForeground(Color.BLUE);
        menuBar.add(menuIntercityCab);

        viewCabs = new JMenuItem("VIEW CABS");
        menuIntercityCab.add(viewCabs);
        viewCabs.addActionListener(this);

        bookCab = new JMenuItem("BOOK CAB");
        menuIntercityCab.add(bookCab);
        bookCab.addActionListener(this);

        viewIntercityBookCab = new JMenuItem("VIEW BOOKED CAB");
        menuIntercityCab.add(viewIntercityBookCab);
        viewIntercityBookCab.addActionListener(this);


        menuTransport = new JMenu("TRANSPORT");
        menuTransport.setForeground(Color.RED);
        menuBar.add(menuTransport);

        bookpackage = new JMenuItem("BOOK PACKAGE");
        bookpackage.addActionListener(this);
        menuTransport.add(bookpackage);

        viewBookedPackage = new JMenuItem("VIEW BOOKED PACKAGE");
        viewBookedPackage.addActionListener(this);
        menuTransport.add(viewBookedPackage);


        menuBill = new JMenu("BILL");
        menuBill.setForeground(Color.BLUE);
        menuBar.add(menuBill);

        checkBill = new JMenuItem("CHECK BILL");
        menuBill.add(checkBill);
        checkBill.addActionListener(this);

        menuPayment = new JMenu("PAYMENT");
        menuPayment.setForeground(Color.RED);
        menuBar.add(menuPayment);

        pay = new JMenuItem("PAY BY bKASH");
        pay.addActionListener(this);
        menuPayment.add(pay);

        menuUtility = new JMenu("UTILITY");
        menuUtility.setForeground(Color.blue);
        menuBar.add(menuUtility);

        notepad = new JMenuItem("NOTEPAD");
        menuUtility.add(notepad);
        notepad.addActionListener(this);

        calculator = new JMenuItem("CALCULATOR");
        menuUtility.add(calculator);
        calculator.addActionListener(this);

        menuAbout = new JMenu("About");
        menuAbout.setForeground(Color.RED);
        menuBar.add(menuAbout);

        about = new JMenuItem("About");
        menuAbout.add(about);
        about.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Connections connections = new Connections();

        try{
            if(event.getSource() == addCustomer){
                new AddCustomer(username).setVisible(true);
            }
            else if(event.getSource() == updateCustomer){
                new UpdateCustomer(username).setVisible(true);
            }
            else if(event.getSource() == viewCustomer){
                new ViewCustomer().setVisible(true);
            }
            else if(event.getSource() == deleteCustomer){
                new DeleteCustomer().setVisible(true);
            }
            else if(event.getSource() == bookcab){
                new BookCab(username).setVisible(true);
            }
            else if(event.getSource() == viewbookcab){
                new ViewBookedCab(username).setVisible(true);
            }
            else if(event.getSource() == viewCabs){
                new ViewCabs().setVisible(true);
            }
            else if(event.getSource() == bookCab){
                new BookIntercityCab(username).setVisible(true);
            }
            else if(event.getSource() == viewbookcab){
                new ViewIntercityBookedCab(username).setVisible(true);
            }
            else if(event.getSource() == bookpackage){
                new Trucking(username).setVisible(true);
            }
            else if(event.getSource() == viewBookedPackage){
                new ViewTruckingDetails(username).setVisible(true);
            }
            else if(event.getSource() == checkBill){
                new CheckBill(username).setVisible(true);
            }
            else if(event.getSource() == pay){
                new Payment().setVisible(true);
            }
            else if(event.getSource() == notepad){
                Runtime.getRuntime().exec("notepad.exe");
            }
            else if(event.getSource() == calculator){
                Runtime.getRuntime().exec("calc.exe");
            }
            else if(event.getSource() == about){
                new About().setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
}
