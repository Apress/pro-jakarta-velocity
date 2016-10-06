/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author robh
 */
public class Mailer {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Apress Mailer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.setContentPane(new MailerPanel());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
