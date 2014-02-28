package ca.uwo.csd.cs2212.team5;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MainWindow window = new MainWindow();
        window.setVisible(true);
      }
    });
  }
}