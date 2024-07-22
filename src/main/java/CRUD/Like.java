package CRUD;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DAO.FavouriteDAO;
import Entity.Users;
import Entity.Videos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/like")
public class Like extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user;
		if (req.getSession().getAttribute("user") != null) {
			user = (Users) req.getSession().getAttribute("user");
			String id = req.getParameter("id");
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
	  		EntityManager em = factory.createEntityManager();
	  		
	  		TypedQuery<Videos> query = em.createNamedQuery("Videos.findById", Videos.class);
	  		query.setParameter("videoId", id);
	  		Videos video = query.getSingleResult();
	  		
	  		try {
				FavouriteDAO dao = new FavouriteDAO();
				dao.create(user, video);
			} catch (Exception e) {
				System.out.println(e);
			}
	  		resp.sendRedirect("./detail?id=" + id);
		}
		else {
			req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
		}
	}
}
