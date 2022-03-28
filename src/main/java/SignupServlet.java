
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Servers")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final Logger log = Logger.getLogger(SignupServlet.class);
		String path = "log4j.properties";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Signup ob = new Signup();
		try {
			ob.deleteTable();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		if (!ob.mailCheck(email)) {
			PropertyConfigurator.configure(path);
			String ans = ob.mail(email);

			if (!ans.equals("")) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("ootp", ans);

				response.sendRedirect("otp.html");
			} else {

				System.out.println("Please try again");
			}
		} else {
			log.info(formatter.format(date) + " Already exist this email id");
			System.out.println("This email id alredy exist");
			PrintWriter out = response.getWriter();
			out.print("Something went wrong, Please check your Email id or Password.");
			out.print("Please check Logger file");
		}
	}

}
