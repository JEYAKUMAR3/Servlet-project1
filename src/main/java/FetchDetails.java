
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Result")
public class FetchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Firstbat firstbat = new Firstbat();
		String arr[] = new String[4];
		try {
			arr = firstbat.fetchData();
			PrintWriter out = response.getWriter();

			JSONObject obj = new JSONObject();

			obj.put("teamname", arr[0]);
			obj.put("score", arr[1]);
			obj.put("teamname2", arr[2]);
			obj.put("score2", arr[3]);
			
			System.out.println(obj.toString());
			out.write(obj.toString());
			out.flush();
			out.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
