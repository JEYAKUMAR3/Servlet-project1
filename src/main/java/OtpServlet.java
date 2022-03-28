
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@WebServlet("/Otp")
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sotp = request.getParameter("auth");
		Signup obj = new Signup();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		String ootp = (String) session.getAttribute("ootp");

		session.removeAttribute("name");
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.removeAttribute("ootp");

		try {
			String state = obj.signup(ootp, sotp, name, email, password);
			System.out.println(state);
			response.sendRedirect("teams.html");
		} catch (ClassNotFoundException e) {

			System.out.println(e);
		}

	}

}
