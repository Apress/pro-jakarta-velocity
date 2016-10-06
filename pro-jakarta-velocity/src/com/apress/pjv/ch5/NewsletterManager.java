/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author robh
 */
public class NewsletterManager {

    private static final String SMTP_SERVER = "smtp.nildram.co.uk";

    private Session session = null;

    private Address fromAddress = null;

    private String subject = null;

    public NewsletterManager(String fromAddress, String subject)
            throws NewsletterException {
        try {
            this.fromAddress = new InternetAddress(fromAddress);
        } catch (AddressException ex) {
            throw new NewsletterException("Invalid from address", ex);
        }
        this.subject = subject;
    }

    public boolean sendNewsletter(NewsletterSection[] sections,
            Subscriber subscriber) throws NewsletterException {

        NewsletterTemplate template = NewsletterTemplateFactory.getInstance()
                .getNewsletterTemplate(subscriber.getPreferredFormat());

        template.setSections(sections);
        template.setSubscriber(subscriber);

        try {

            Message msg = new MimeMessage(getMailSession());
            msg.setContent(template.generate(), subscriber.getPreferredFormat()
                    .getContentType());

            msg.setSubject(subject);
            msg.setFrom(fromAddress);

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    subscriber.getEmailAddress()));

            Transport.send(msg);
            return true;
        } catch (AddressException e) {
            // invalid address - ignore
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new NewsletterException("Unable to send newsletter", e);
        }
    }

    private Session getMailSession() {
        if (session == null) {
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_SERVER);
            session = Session.getDefaultInstance(props);
        }

        return session;
    }

}
