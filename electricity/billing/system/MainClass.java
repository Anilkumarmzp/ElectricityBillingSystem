package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame implements ActionListener {
    MainClass(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // Home page

        JMenu home = new JMenu("Home");
        home.setForeground(Color.BLACK);
        home.addActionListener(this);
        mb.add(home);

        JMenuItem Home = new JMenuItem("Home");
        Home.setBackground(Color.WHITE);
        Home.addActionListener(this);
        home.add(Home);

        // about

        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        about.addActionListener(this);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        About.addActionListener(this);
        about.add(About);



        // Gallery

        JMenu gallery = new JMenu("Gallery");
        gallery.setForeground(Color.BLACK);
        gallery.addActionListener(this);
        mb.add(gallery);

        JMenuItem Gallery = new JMenuItem("Gallery");
        Gallery.setBackground(Color.WHITE);
        Gallery.addActionListener(this);
        gallery.add(Gallery);

        // Contact

        JMenu contact = new JMenu("Contact");
        contact.setForeground(Color.BLACK);
        contact.addActionListener(this);
        mb.add(contact);

        JMenuItem Contact = new JMenuItem("Contact");
        Contact.setBackground(Color.WHITE);
        Contact.addActionListener(this);
        contact.add(Contact);

        // Login

        JMenu login = new JMenu("Login");
        login.setForeground(Color.BLACK);
        mb.add(login);

        JMenuItem Login = new JMenuItem("Login");
        Login.setBackground(Color.WHITE);
        Login.addActionListener(this);
        login.add(Login);

        //New Registration

        JMenu NewRegistration = new JMenu("New Registration");
        NewRegistration.setForeground(Color.BLACK);
        mb.add(NewRegistration);

        JMenuItem newRegistration = new JMenuItem("New Registration");
        newRegistration.setBackground(Color.WHITE);
        newRegistration.addActionListener(this);
        NewRegistration.add(newRegistration);



        // exit

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("Home")) {
            new MainClass();
        } else if (sm.equals("About")) {
            new About().setVisible(true);
        } else if (sm.equals("Gallery")) {
            new Gallery();
        } else if (sm.equals("Contact")) {
            new ContactPage().setVisible(true);
        } else if(sm.equals("Login")){
            new Login();
        } else if (sm.equals("New Registration")) {
            new ElectricityRegistrationForm();
        }


    }

    public static void main(String[] args) {
        new MainClass();
    }
}