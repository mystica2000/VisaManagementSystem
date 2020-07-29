import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class EmailSend{			
		
		
	public EmailSend(String acc,String email,String pass)
	{
        final String username = "emailid";
        final String password = "password";

        Properties props = new Properties();
       props.put("mail.smtp.user","username");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "25");
props.put("mail.debug", "true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.EnableSSL.enable","true");

props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
props.setProperty("mail.smtp.socketFactory.fallback", "false");  
props.setProperty("mail.smtp.port", "465");  
props.setProperty("mail.smtp.socketFactory.port", "465");
       
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mysticainf@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Account Activation");
            message.setText("Password Recovery,"
                + "\n\n Dear User, \n\n Here is youre password for your account "+acc+" and the password is "+pass+"\n\n You can change your password now"+
            		"\n You are requested to update your details");

            Transport.send(message);

            System.out.println("Done");

        }

        catch (MessagingException e)
        {
            // throw new RuntimeException(e);
            System.out.println(e);
        }
	}
	
	
	public static void main(String args[])
		{
		}
}