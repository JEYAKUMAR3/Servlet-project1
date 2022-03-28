
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Players")
public class PlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> list = new ArrayList<>();
		list.add(request.getParameter("player1_name"));
		list.add(request.getParameter("player2_name"));
		list.add(request.getParameter("player3_name"));
		list.add(request.getParameter("player4_name"));
		list.add(request.getParameter("player5_name"));
		list.add(request.getParameter("player6_name"));
		list.add(request.getParameter("player7_name"));
		list.add(request.getParameter("player8_name"));
		list.add(request.getParameter("player9_name"));
		list.add(request.getParameter("player10_name"));
		list.add(request.getParameter("player11_name"));
		System.out.println(list);
		Player_name ob = new Player_name();
		try {
			ob.TeamA_players(list);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}

		System.out.println("Team A players name added");

		ArrayList<String> lists = new ArrayList<>();
		lists.add(request.getParameter("player_name1"));
		lists.add(request.getParameter("player_name2"));
		lists.add(request.getParameter("player_name3"));
		lists.add(request.getParameter("player_name4"));
		lists.add(request.getParameter("player_name5"));
		lists.add(request.getParameter("player_name6"));
		lists.add(request.getParameter("player_name7"));
		lists.add(request.getParameter("player_name8"));
		lists.add(request.getParameter("player_name9"));
		lists.add(request.getParameter("player_name10"));
		lists.add(request.getParameter("player_name11"));

		HttpSession session = request.getSession();
		session.setAttribute("team1", list);
		session.setAttribute("team2", lists);

		Player_name obj = new Player_name();
		try {
			obj.TeamB_players(lists);
		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(e);
		}

		System.out.println("Team B players name added");
		response.sendRedirect("overs.html");

	}

}
