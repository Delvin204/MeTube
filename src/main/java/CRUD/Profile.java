package CRUD;

import java.io.IOException;

import DAO.UserDAO;
import Entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class Profile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") != null) {
			Users user = (Users) req.getSession().getAttribute("user");
			req.setAttribute("userInfo", user);
			req.setAttribute("messProfile", "");
			req.getRequestDispatcher("/views/crud/profile.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		Users user = (Users) req.getSession().getAttribute("user");
		
		try {
			Users profile = new Users();
			profile.setId(req.getParameter("id"));
			profile.setPassword(req.getParameter("password"));
			profile.setFullname(req.getParameter("fullname"));
			profile.setEmail(req.getParameter("email"));
			profile.setAdmin(user.getAdmin());
			
			dao.update(profile);
			
			req.getSession().invalidate();
			req.getSession().setAttribute("user", profile);
			req.setAttribute("messProfile", "Update thành công");
		} catch (Exception e) {
			req.setAttribute("messProfile", "Update thất bại");
		}
		req.setAttribute("userInfo", user);
		req.getRequestDispatcher("/views/crud/profile.jsp").forward(req, resp);
	}
}
