package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class Paytm extends JFrame {
    JEditorPane j;
    JScrollPane scrollPane;
    JButton backButton;
    JButton openBrowserButton;

    Paytm() {
        j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com");
        } catch (Exception e) {
            e.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Could not load Paytm</html>");
        }

        scrollPane = new JScrollPane(j);
        scrollPane.setBounds(20, 20, 760, 450); // Position and size for the web view

        openBrowserButton = new JButton("Open in Browser");
        openBrowserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    URI paytmURL = new URI("https://paytm.com");
                    Desktop.getDesktop().browse(paytmURL);
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Paytm.this, "Could not open Paytm in the browser.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        openBrowserButton.setBounds(580, 480, 180, 40); // Position for the open in browser button

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose(); // Release window resources
            }
        });
        backButton.setBounds(20, 480, 100, 40); // Position for the back button

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null); // Use null layout for manual positioning
        contentPane.add(scrollPane);
        contentPane.add(openBrowserButton);
        contentPane.add(backButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setPreferredSize(new Dimension(800, 600));

        setSize(800, 600);
        setLocation(600, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}