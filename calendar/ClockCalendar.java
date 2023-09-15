/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.calendar;

import static com.sun.javafx.scene.control.skin.ScrollBarSkin.DEFAULT_WIDTH;
import java.awt.BorderLayout;
import java.awt.Color;
import static javafx.beans.binding.Bindings.add;
import javax.swing.JFrame;

/**
 *
 * @author xingl
 */
public class ClockCalendar {
        

    public ClockCalendar() {
      JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
      
      //ClockPanel clockPanel = new ClockPanel();
      ClockPanel clock = new ClockPanel(300,300);
      CalendarPanel calendarPanel = new CalendarPanel();
      f.setSize(420, 475);
      f.add(clock, BorderLayout.NORTH);
      //f.setBorder(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBackground(Color.yellow);
     f.add(calendarPanel, BorderLayout.SOUTH);
     while (true) {
      f.repaint();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
     
     f.show();
     } 
    
   // JFrame frame = new JFrame("Clock");
  //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //  frame.setContentPane(clock);
  //  frame.pack();
  //  frame.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ClockCalendar pepe = new ClockCalendar();
       
    
  }
}





//   JFrame frame = new JFrame("Clock and Calendar");
     //   frame.add(ClockCalendar pie= new ClockCalendar()).
     // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     /// frame.setContentPane(new MainPanel());
     // frame.pack();
      //frame.setVisible(true);    }
    

