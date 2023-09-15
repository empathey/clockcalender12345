/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javax.swing.*;

public class CalendarPanel extends JPanel {
  
  public String[] dates;
   public JButton[] buttons;
     LocalDate now = LocalDate.now();
   public int daysInMonth = now.lengthOfMonth();
   public CalendarPanel() {
      setLayout(new GridLayout(0, 7));
      
    
      
      
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

      dates = new String[daysInMonth];
      for (int i = 0; i < daysInMonth; i++) {
         LocalDate d = now.withDayOfMonth(i+1);
         String formattedDate = d.format(formatter);
         dates[i] = formattedDate;
      }
      
      buttons = new JButton[daysInMonth];
      for (int i = 0; i < daysInMonth; i++) {
         buttons[i] = new JButton(dates[i]);
         add(buttons[i]);
         buttons[i].setBackground(Color.RED);
         buttons[i].addActionListener((event) -> {
    // do stuff hereToggleButton source = (ToggleButton) event.getSource();
     //    if(source.isSelected()) {
            
     //    } else {
        for(int r=0; r<buttons.length; r++){
          if(event.getSource() == buttons[r]){
             buttons[r].setBackground(Color.BLUE);
           
             MyFrame peter = new MyFrame();
             //peter.setVisible(true);
          }
                 }
         } }
                 }
   }


