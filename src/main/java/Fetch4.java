

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

@WebServlet("/Fetch4")
public class Fetch4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		ArrayList<String> list4 = (ArrayList<String>) ses.getAttribute("run2");
		JSONArray ob = new JSONArray();
		ob.add(list4);
		out.write(ob.toJSONString());
		out.flush();
		out.close();
	}

}
