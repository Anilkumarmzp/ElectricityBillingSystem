package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class About extends JFrame {
    public About(){
        setTitle("Power Plant Information");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adding the title
        JLabel titleLabel = new JLabel("Power Plant");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        // Adding the description
        JTextArea descriptionArea = new JTextArea(
                "A power plant is an industrial facility that generates electricity from primary energy. " +
                        "Most power plants use one or more generators that convert mechanical energy into electrical energy " +
                        "in order to supply power to the electrical grid for society's electrical needs. The exception is solar " +
                        "power plants, which use photovoltaic cells (instead of a turbine) to generate this electricity."+
                "The type of primary fuel or primary energy flow that provides a power plant its primary energy varies."+
                        " The most common fuels are coal, natural gas, and uranium (nuclear power). "+
                        "A substantially used primary energy flow for electricity generation is hydroelectricity (water). "+
                        "Other flows that are used to generate electricity include wind, solar, geothermal and tidal."+

        "Different countries get their electricity from different types of power plants."+
                        "For example, in Canada, most electricity generation comes from hydroelectric power plants which accounts for about 60% of the total electricity generated in Canada."+
                        "Please see the data visualization below to explore how countries around the world get their electricity."
        );
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(descriptionArea);

        // Adding the image
        try {
            JLabel imageLabel = new JLabel(new ImageIcon(ImageIO.read(new File("icon/e.jpeg"))));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adding the examples title
        JLabel examplesTitleLabel = new JLabel("Examples of Power Plants");
        examplesTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        examplesTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(examplesTitleLabel);

        // Adding the example descriptions
        JTextArea examplesArea = new JTextArea(
                "Coal-fired power plant.\nNuclear power plant.\nWind power farm."
        );
        examplesArea.setWrapStyleWord(true);
        examplesArea.setLineWrap(true);
        examplesArea.setOpaque(false);
        examplesArea.setEditable(false);
        examplesArea.setFocusable(false);
        examplesArea.setFont(new Font("Arial", Font.PLAIN, 14));
        examplesArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(examplesArea);


       // setLayout(null);
       // setVisible(true);

        // Adding the main panel to the frame
        add(panel);
        setLocation(500,200);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            About ex = new About();
            ex.setVisible(true);
        });
        new About();
    }
}
