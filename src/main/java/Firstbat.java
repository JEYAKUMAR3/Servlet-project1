import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;

import jakarta.servlet.http.HttpSession;

public class Firstbat {
	public String Team1_name = "";
	public String Team2_name = "";
	public int score1;
	public int score2;
	public String Win_team;

	final static Logger log = Logger.getLogger(Firstbat.class);
	static String path = "/home/jeya-zstk225/eclipse-workspace/Email/src/main/java/log4j.properties";
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date = new Date();

	public void Batting(ArrayList<String> list1, ArrayList<Integer> list2) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
		PreparedStatement stmt1 = con.prepareStatement("select Team_name from team1 where T_id=?");
		stmt1.setString(1, "1");
		ResultSet rs = stmt1.executeQuery();

		while (rs.next()) {
			Team1_name = rs.getString(1);
		}

		PreparedStatement stmt2 = con.prepareStatement("insert into score1(Team_name, batter, runs) values(?,?,?)");

		System.out.println(Team1_name);
		for (int i = 0; i < 11; i++) {
			stmt2.setString(1, Team1_name);

			stmt2.setString(2, list1.get(i));
			stmt2.setInt(3, list2.get(i));

			score1 += list2.get(i);
			System.out.println(list2.get(i));
			stmt2.executeUpdate();
		}
		PreparedStatement stmt3 = con.prepareStatement("insert into total1(T_id, Team1_name,score1) values(?,?,?)");
		int T_id = 1;
		stmt3.setInt(1, T_id);
		stmt3.setString(2, Team1_name);
		stmt3.setInt(3, score1);
		stmt3.executeUpdate();
		System.out.println(Team1_name + " score: " + score1);

//		HttpSession ses1 =  new HttpSession();
//		ses1.setAttribute("total1",stmt3);
	}

	public String[] fetchData() throws ClassNotFoundException, SQLException {

		String arr[] = new String[4];
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");

		PreparedStatement ps = con.prepareStatement("select Team1_name,score1,Team2_name,score2 from total1,total2");
		ResultSet rs = ps.executeQuery();
		System.out.println(ps);
//		String arr[]= {rs.getString(1),rs.getString(2)};
		if (rs.next()) {
			arr[0] = rs.getString(1);
			arr[1] = rs.getString(2);
			arr[2] = rs.getString(3);
			arr[3] = rs.getString(4);
			
		}
		System.out.println(Arrays.toString(arr));
		return arr;

	}

	public void Batting2(ArrayList<String> list3, ArrayList<Integer> list4)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Score", "root", "");
		PreparedStatement stmt = con.prepareStatement("select Team_name from team2 where T_id=?");
		stmt.setString(1, "2");
		ResultSet rs1 = stmt.executeQuery();
		String Team2_name = "";
		while (rs1.next()) {
			Team2_name = rs1.getString(1);
			System.out.println(Team2_name);
		}

		PreparedStatement stmt1 = con.prepareStatement("insert into score2(Team_name, batter, runs) values(?,?,?) ");

//		int score2 = 0;
		for (int i = 0; i < 11; i++) {

			stmt1.setString(1, Team2_name);

			stmt1.setString(2, list3.get(i));
			stmt1.setInt(3, list4.get(i));

			score2 += list4.get(i);
			System.out.print(list3.get(i));
			System.out.println(":" + list4.get(i));
			stmt1.executeUpdate();

		}
		PreparedStatement stmt5 = con.prepareStatement("insert into total2(T_id, Team2_name, score2) values(?,?,?)");
		int T_id = 2;
		stmt5.setInt(1, T_id);
		stmt5.setString(2, Team2_name);
		stmt5.setInt(3, score2);
		stmt5.executeUpdate();
		System.out.println(Team2_name + " score " + score2);

//	public String Scoreboard(String Team1_name,String Team2_name,int run) throws Exception{

		PreparedStatement stmt3 = con.prepareStatement("select Team_name from team1 where T_id=?");
		stmt3.setString(1, "1");
		ResultSet rs2 = stmt3.executeQuery();
		while (rs2.next()) {
			Team1_name = rs2.getString(1);
		}
		PreparedStatement stmt4 = con.prepareStatement("select score1 from total1 where T_id=?");
		stmt4.setInt(1, 1);
		ResultSet rs3 = stmt4.executeQuery();
		while (rs3.next()) {
			score1 = rs3.getInt(1);
		}
		PreparedStatement stmt2 = con.prepareStatement(
				"insert into scoreboard( Team1_name, Score1, Team2_name, Score2,Winning_team, Win_by) values(?,?,?,?,?,?)");

		System.out.println(Team1_name);
		System.out.println(Team2_name);

		stmt2.setString(1, Team1_name);
		stmt2.setInt(2, score1);
		stmt2.setString(3, Team2_name);
		stmt2.setInt(4, score2);

		if (score1 > score2) {
			stmt2.setString(5, Team1_name);

		} else if (score1 < score2) {
			stmt2.setString(5, Team2_name);
		} else if (score1 == score2) {
			stmt2.setString(5, "Match die");
		}

		if (score1 > score2) {
			int run = score1 - score2;
			System.out.println(run);
			System.out.println(Team1_name + " Win by " + run + " runs");
			stmt2.setInt(6, run);
		} else if (score2 > score1) {
			int run = score2 - score1;
			System.out.println(run);
			System.out.println(Team2_name + " Win by " + run + " runs");
			stmt2.setInt(6, run);
		} else if (score1 == score2) {
			System.out.println("Match die");
			stmt2.setString(6, "Match die");
		}
		stmt2.executeUpdate();

	}



}
