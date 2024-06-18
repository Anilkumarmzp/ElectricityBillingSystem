package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Gallery extends JFrame {
    public Gallery(){
        setTitle("Gallery");
        // image1
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/e1.jpg"));
        Image Img1 = img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon1 = new ImageIcon(Img1);
        JLabel ImgLabel = new JLabel(imgIcon1);
        ImgLabel.setBounds(40,30,250,250);
        add(ImgLabel);

        // image2
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("icon/e2.jpg"));
        Image Img2 = img2.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon2 = new ImageIcon(Img2);
        JLabel ImgLabel2 = new JLabel(imgIcon2);
        ImgLabel2.setBounds(360,30,250,250);
        add(ImgLabel2);

        // Image3
        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("icon/e3.jpg"));
        Image Img3 = img3.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon3 = new ImageIcon(Img3);
        JLabel ImgLabel3 = new JLabel(imgIcon3);
        ImgLabel3.setBounds(680,30,250,250);
        add(ImgLabel3);

        // Image4
        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("icon/e4.jpg"));
        Image Img4 = img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon4 = new ImageIcon(Img4);
        JLabel ImgLabel4 = new JLabel(imgIcon4);
        ImgLabel4.setBounds(1000,30,250,250);
        add(ImgLabel4);

        // Image5
        ImageIcon img5 = new ImageIcon(ClassLoader.getSystemResource("icon/e5.jpeg"));
        Image Img5 = img5.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon5 = new ImageIcon(Img5);
        JLabel ImgLabel5 = new JLabel(imgIcon5);
        ImgLabel5.setBounds(40,340,250,250);
        add(ImgLabel5);

        // Image6
        ImageIcon img6 = new ImageIcon(ClassLoader.getSystemResource("icon/e6.jpeg"));
        Image Img6 = img6.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon6 = new ImageIcon(Img6);
        JLabel ImgLabel6 = new JLabel(imgIcon6);
        ImgLabel6.setBounds(360,340,250,250);
        add(ImgLabel6);

        // Image7

        ImageIcon img7 = new ImageIcon(ClassLoader.getSystemResource("icon/e7.jpeg"));
        Image Img7 = img7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon7 = new ImageIcon(Img7);
        JLabel ImgLabel7 = new JLabel(imgIcon7);
        ImgLabel7.setBounds(680,340,250,250);
        add(ImgLabel7);

        // Image8
        ImageIcon img8 = new ImageIcon(ClassLoader.getSystemResource("icon/e9.jpg"));
        Image Img8 = img8.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imgIcon8 = new ImageIcon(Img8);
        JLabel ImgLabel8 = new JLabel(imgIcon8);
        ImgLabel8.setBounds(1000,340,250,250);
        add(ImgLabel8);




        setSize(1500,800);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Gallery();
    }
}
