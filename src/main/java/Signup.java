
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Signup {

	final static Logger log = Logger.getLogger(Signup.class);
	String path = "/home/jeya-zstk225/eclipse-workspace/Email/src/main/java/log4j.properties";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();

	public String signup(String ootp, String sotp, String name, String email, String password)
			throws ClassNotFoundException {

		System.out.println("sotp " + sotp);
		System.out.println("ootp " + ootp);
		if (sotp.equals(ootp)) {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
			try {
				PropertyConfigurator.configure(path);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
				PreparedStatement stmt = con.prepareStatement("insert into email2(name,email,password) values(?,?,?)");

				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, password);
				System.out.println(stmt);
				stmt.executeUpdate();

				return "Account Created";

			} catch (SQLException se) {
				log.info(formatter.format(date) + " Already exist this email id");

			}
		}

		else {

			log.info(formatter.format(date) + " Please Enter correct otp");
			return "Please Enter correct otp";

		}
		return password;
	}

	public String mail(String mail) {

		Random rd = new Random();
		int r = rd.nextInt(100000) + 99999;
		String ootp1 = String.valueOf(r);
		Mail mail1 = new Mail();
		if (mail1.SendMail(mail, "", ootp1))
			return ootp1;
		else
			return "";
	}

	public Boolean mailCheck(String mail) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
			PreparedStatement stmt = con.prepareStatement("select * from email2 where email = ?");
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}
	
	public void deleteTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score","root","");
		PreparedStatement stmt;
		stmt = con.prepareStatement("delete from team1");
		stmt = con.prepareStatement("delete from team2");
		stmt = con.prepareStatement("delete from playersA");
		stmt = con.prepareStatement("delete from playersB");
		stmt = con.prepareStatement("delete from score1");
		stmt = con.prepareStatement("delete from score2");
		stmt = con.prepareStatement("delete from total1");
		stmt = con.prepareStatement("delete from total2");
	}

}
