
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.http.HttpSession;

@WebServlet("/Teams")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Team1_name = request.getParameter("Team1_name");
		String Team2_name = request.getParameter("Team2_name");

		if (!Team1_name.equals("") && !Team2_name.equals("")) {
			try {
				Teams ob = new Teams();
				ob.TeamA(Team1_name);
				ob.TeamB(Team2_name);
				response.sendRedirect("players.html");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			response.sendRedirect("teams.html");
		}

	}

}
