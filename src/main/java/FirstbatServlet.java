
//import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebServlet("/Firstbat")
public class FirstbatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final static Logger log = Logger.getLogger(FirstbatServlet.class);

	static String path = "/home/jeya-zstk225/eclipse-workspace/Email/src/main/java/log4j.properties";
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date = new Date();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		list1.add(request.getParameter("player1_name"));
		list2.add(Integer.valueOf(request.getParameter("runs1")));

		list1.add(request.getParameter("player2_name"));
		list2.add(Integer.valueOf(request.getParameter("runs2")));

		list1.add(request.getParameter("player3_name"));
		list2.add(Integer.valueOf(request.getParameter("runs3")));

		list1.add(request.getParameter("player4_name"));
		list2.add(Integer.valueOf(request.getParameter("runs4")));

		list1.add(request.getParameter("player5_name"));
		list2.add(Integer.valueOf(request.getParameter("runs5")));

		list1.add(request.getParameter("player6_name"));
		list2.add(Integer.valueOf(request.getParameter("runs6")));

		list1.add(request.getParameter("player7_name"));
		list2.add(Integer.valueOf(request.getParameter("runs7")));

		list1.add(request.getParameter("player8_name"));
		list2.add(Integer.valueOf(request.getParameter("runs8")));

		list1.add(request.getParameter("player9_name"));
		list2.add(Integer.valueOf(request.getParameter("runs9")));

		list1.add(request.getParameter("player10_name"));
		list2.add(Integer.valueOf(request.getParameter("runs10")));

		list1.add(request.getParameter("player11_name"));
		list2.add(Integer.valueOf(request.getParameter("runs11")));

		HttpSession ses = request.getSession();
		ses.setAttribute("run1", list2);

		Firstbat ob = new Firstbat();
		try {
			ob.Batting(list1, list2);
			response.sendRedirect("batting.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
