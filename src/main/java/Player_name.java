import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Player_name {

	public String TeamA_players(ArrayList<String> list) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
		PreparedStatement stmt = con.prepareStatement("insert into playersA(player1_name) values(?)");

		for (int i = 0; i < list.size(); i++) {

			stmt.setString(1, list.get(i));
			stmt.executeUpdate();
		}

		return "A team players name added";

	}

	public String TeamB_players(ArrayList<String> lists) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
		PreparedStatement stmt = con.prepareStatement("insert into playersB(player2_name) values(?)");

		for (int i = 0; i < lists.size(); i++) {

			stmt.setString(1, lists.get(i));
			stmt.executeUpdate();
		}

		return "B Team players name added";

	}
}
