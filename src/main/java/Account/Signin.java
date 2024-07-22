package Account;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class Signin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") != null) {
			resp.sendRedirect("./index");
            return;
		}
		else {
			req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
		EntityManager em = factory.createEntityManager();
		
		try {
			TypedQuery<Users> query = em.createNamedQuery("Users.findById", Users.class);
			query.setParameter("id", username);
			Users user = query.getSingleResult();
			
			if (user.getPassword().equals(password)) {
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("./index");
	            return;
			}
			else {
				req.setAttribute("mess", "Password không chính xác");
			}
			
		} catch (Exception e) {
			req.setAttribute("mess", "Username không chính xác");
		}
		req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
	}
}
