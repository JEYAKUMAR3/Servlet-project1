
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
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		System.out.println("reached fetch");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("team1");

		JSONArray obj = new JSONArray();
		obj.add(list);
		out.write(obj.toJSONString());
		out.flush();
		out.close();
	}

}
