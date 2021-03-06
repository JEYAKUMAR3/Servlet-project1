import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Mail {

	public boolean SendMail(String to, String subject, String msg_body) {
		System.out.println(to + " " + subject + " " + msg_body);
		String from = "jeyakumar662000@gmail.com";
		String pass = "8489851490";
		boolean mail_status = false;
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", true);

		Myauth auth = new Myauth(from, pass);
		auth.getPasswordAuthentication();
		props.put("mail.debug", "true");
		Session ses = (Session) Session.getInstance(props, auth);
		try {
			Message msg = new MimeMessage(ses);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText("Your signup otp is :" + msg_body + "\n This is for Check your usability");
			Transport.send(msg);
			mail_status = true;
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		return mail_status;
	}
}

class Myauth extends Authenticator {
	String Username = null;
	String Password = null;

	public Myauth(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(Username, Password);
	}
}