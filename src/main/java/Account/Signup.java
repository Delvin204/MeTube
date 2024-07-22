package Account;

import java.io.IOException;

import DAO.UserDAO;
import Entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/account/signup.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		Users user = new Users();
		
		user.setId(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setFullname(req.getParameter("fullname"));
		user.setEmail(req.getParameter("email"));
		user.setAdmin(false);
		user.setFavourites(null);
		
		dao.create(user);
		req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
	}
}
