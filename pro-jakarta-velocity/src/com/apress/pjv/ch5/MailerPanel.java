/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author robh
 */
public class MailerPanel extends JPanel implements ActionListener {

    private JTextField subjectField = null;

    private JTextField fromAddressField = null;

    private JTextArea categoryContentField = null;

    private JList categoryList = null;

    private JButton sendButton = null;
    
    private JProgressBar progressBar = null;

    private int selectedCategory = -1;

    private Category[] categories = null;

    private String[] content = null;

    public MailerPanel() {
        super(new GridBagLayout());

        loadData();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.insets = new Insets(5, 5, 5, 5);

        addFieldLabels(c);

        addSubjectField(c);

        addFromAddressField(c);

        addCategoryList(c);

        addCategoryContentsLabel(c);

        addCategoryContentsTextBox(c);
        
        addProgessBar(c);

        addSendButton(c);

    }

    private void addFieldLabels(GridBagConstraints c) {
        // labels
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Subject: "), c);

        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("From Address: "), c);
    }

    private void addSubjectField(GridBagConstraints c) {
        // text fields
        c.gridx = 1;
        c.gridy = 0;

        subjectField = new JTextField();
        subjectField.setText("Apress Newsletter");
        c.ipadx = 150;
        add(subjectField, c);
    }

    private void addFromAddressField(GridBagConstraints c) {
        c.gridx = 1;
        c.gridy = 1;

        fromAddressField = new JTextField();
        fromAddressField.setText("newsletter@apress.com");
        c.ipadx = 150;
        add(fromAddressField, c);
    }

    private void addCategoryList(GridBagConstraints c) {
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        categoryList = new JList();
        categoryList.setListData(categories);
        categoryList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting() == false) {
                    updateCategoryContents();
                }
            }
        });
        categoryList.setSelectedIndex(0);
        add(categoryList, c);
    }
    
    private void addProgessBar(GridBagConstraints c) {
        c.gridx = 0;
        c.gridy = 5;
        c.ipady = 40;
        progressBar = new JProgressBar();
        add(progressBar, c);
    }

    private void addSendButton(GridBagConstraints c) {
        c.gridx = 0;
        c.gridy = 6;
        c.ipady = 30;
        c.ipadx = 100;
        sendButton = new JButton("Send Newsletters");
        sendButton.setActionCommand("send");
        sendButton.addActionListener(this);
        add(sendButton, c);
    }

    private void addCategoryContentsTextBox(GridBagConstraints c) {
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 250;
        c.ipady = 100;
        categoryContentField = new JTextArea();
        categoryContentField.setLineWrap(true);
        categoryContentField.setWrapStyleWord(true);
        JScrollPane scroller = new JScrollPane(categoryContentField);
        add(scroller, c);
    }

    private void addCategoryContentsLabel(GridBagConstraints c) {
        // Category Contents Label
        c.gridx = 0;
        c.gridy = 3;
        add(new JLabel("Category Content:"), c);
    }

    /**
     * Load the list of categories and prepare an array for the category
     * content
     */
    private void loadData() {
        categories = Category.getAllCategories();
        content = new String[categories.length];
    }

    /**
     * This stores the content for the previously selected category and
     * displays the content of the newly selected category
     *  
     */
    private void updateCategoryContents() {
        if (selectedCategory == -1) {
            // this is the first time selection
            selectedCategory = categoryList.getSelectedIndex();
            return;
        }

        saveCurrentContent();

        // display the content for the newly selected category
        categoryContentField.setText(content[categoryList.getSelectedIndex()]);

        // store the new selection
        selectedCategory = categoryList.getSelectedIndex();
    }

    private void saveCurrentContent() {
        // store the content for the previously selected category
        content[selectedCategory] = categoryContentField.getText();
    }

    /**
     * Handles events passed by the components in this panel - this handler
     * only recognises the "send" action.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("send")) {
            new Thread(new Runnable() {

                public void run() {
                    sendNewsletters();
                }
            }).start();
        }
    }

    private synchronized void sendNewsletters() {
        //disable controls
        switchControlState();
        
        // show busy cursor
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        saveCurrentContent();
        
        List subscribers = (new SubscriberManager()).getSubscribers();
        
        progressBar.setMinimum(1);
        progressBar.setMaximum(subscribers.size());
        
        String subject = subjectField.getText();
        String fromAddress = fromAddressField.getText();

        NewsletterSection[] sections = new NewsletterSection[categories.length];

        for (int x = 0; x < sections.length; x++) {
            sections[x] = new NewsletterSection(categories[x], content[x]);
        }

        Iterator itr = subscribers.iterator();
        NewsletterManager manager = new NewsletterManager(fromAddress, subject);

        int count = 1;
        while (itr.hasNext()) {
            Subscriber s = (Subscriber) itr.next();
            manager.sendNewsletter(sections, s);
            progressBar.setValue(count++);
        }
       
        // re-store cursor
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        // re-activate controls
        switchControlState();
       
    }
    
    private void switchControlState() {
        categoryList.setEnabled(!categoryList.isEnabled());
        sendButton.setEnabled(!sendButton.isEnabled());
    }
}
