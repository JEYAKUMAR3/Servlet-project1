
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Secondbat")
public class SecondbatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();

		list3.add(request.getParameter("player_name1"));
		list4.add(Integer.valueOf(request.getParameter("runs1")));

		list3.add(request.getParameter("player_name2"));
		list4.add(Integer.valueOf(request.getParameter("runs2")));

		list3.add(request.getParameter("player_name3"));
		list4.add(Integer.valueOf(request.getParameter("runs3")));

		list3.add(request.getParameter("player_name4"));
		list4.add(Integer.valueOf(request.getParameter("runs3")));

		list3.add(request.getParameter("player_name5"));
		list4.add(Integer.valueOf(request.getParameter("runs5")));

		list3.add(request.getParameter("player_name6"));
		list4.add(Integer.valueOf(request.getParameter("runs6")));

		list3.add(request.getParameter("player_name7"));
		list4.add(Integer.valueOf(request.getParameter("runs7")));

		list3.add(request.getParameter("player_name8"));
		list4.add(Integer.valueOf(request.getParameter("runs8")));

		list3.add(request.getParameter("player_name9"));
		list4.add(Integer.valueOf(request.getParameter("runs9")));

		list3.add(request.getParameter("player_name10"));
		list4.add(Integer.valueOf(request.getParameter("runs10")));

		list3.add(request.getParameter("player_name11"));
		list4.add(Integer.valueOf(request.getParameter("runs11")));

		HttpSession ses2 = request.getSession();
		ses2.setAttribute("run2", list4);

		try {
			Firstbat ob = new Firstbat();
			ob.Batting2(list3, list4);
			response.sendRedirect("result.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}
}
