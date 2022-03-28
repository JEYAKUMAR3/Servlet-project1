
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;

@WebServlet("/Fetch2")
public class Fetch2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("reached fetch2");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList<String> lists = (ArrayList<String>) session.getAttribute("team2");
		JSONArray ob = new JSONArray();
		ob.add(lists);
		out.write(ob.toJSONString());
		out.flush();
		out.close();

	}

}
