/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.calendar;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    private JTextField textField;
    private JButton chickButton;
    private JButton bongButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyFrame();
            }
        });
    }

    public MyFrame() {
        setTitle("Calendar Event Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField = new JTextField("Hello", 20);
        add(textField);
        chickButton = new JButton("Save");
        chickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile(textField.getText());
            }
        });
        add(chickButton);
        bongButton = new JButton("Exit");
        bongButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(bongButton);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        loadFromFile();
    }

    private void saveToFile(String text) {
        try {
            FileWriter writer = new FileWriter("temp.txt");
            writer.write(text);
            writer.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            FileReader reader = new FileReader("temp.txt");
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            textField.setText(line);
            reader.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}