/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;


/**
 * @author robh
 */
public class SwingMVC{

    public static void main(String[] args) {
        JFrame frm = new JFrame();
        frm.setTitle("Swing MVC Demo");
        frm.setSize(200, 300);
        frm.getContentPane().setLayout(new BorderLayout());
        
        
        JList list = new JList();
        final DefaultListModel model = new DefaultListModel();
        model.addElement("Item 1");
        list.setModel(model);

        frm.getContentPane().add(list);
        frm.show();
        
        model.addElement("Item 2");
        model.addElement("Item 3");
        
    }
}
