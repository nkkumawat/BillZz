/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendEmail;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
 

/**
 *
 * @author sonu
 */

 
public class SendEmail {
   public static boolean send(String to ,String sub , String body ) {    
      String recipient = to;
      String sender = "newspaper@gmail.com";
      String host = "127.0.0.1";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);
      try{
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(sender));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
         message.setSubject(sub);
         message.setText(body);
         Transport.send(message);
         System.out.println("Mail successfully sent");
         return true;
      }
      catch (MessagingException mex){
         mex.printStackTrace();
         return false;
      }
   }
}