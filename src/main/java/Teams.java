import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Teams {

	static final Logger log = Logger.getLogger(Teams.class);
	String path = "/home/jeya-zstk225/eclipse-workspace/Email/src/main/java/log4j.properties";
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();

	public String TeamA(String Team1_name) throws SQLException, ClassNotFoundException {

		System.out.println("Teams");

		if (!Team1_name.equals("")) {
			PropertyConfigurator.configure(path);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
			PreparedStatement stmt = con.prepareStatement("insert into team1(T_id,Team_name) values(?,?)");
			int T_id = 1;

			stmt.setInt(1, T_id);
			stmt.setString(2, Team1_name);
			stmt.executeUpdate();
			System.out.println("Team A added");

			return "TeamA created";
		} else {
			log.info(formatter.format(date) + " You didn't add the Team name");
			return "Please add the Team name";
		}

	}

	public String TeamB(String Team2_name) throws Exception {

		if (!Team2_name.equals("")) {
			PropertyConfigurator.configure(path);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
			PreparedStatement stmt = con.prepareStatement("insert into team2(T_id,Team_name) values(?,?)");
			int T_id = 2;

			stmt.setInt(1, T_id);
			stmt.setString(2, Team2_name);
			stmt.executeUpdate();
			System.out.println("Team B added");
			return "TeamB created";
		} else {
			log.info("You didn't add the Team name");
			return "Please add the Team name";
		}

	}

}
