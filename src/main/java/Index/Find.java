package Index;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entity.Videos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/find")
public class Find extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/index/find.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("search");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
  		EntityManager em = factory.createEntityManager();
  		
  		TypedQuery<Videos> query = em.createNamedQuery("Videos.findByKeyword", Videos.class);
  		query.setParameter("keyword", "%" + key + "%");
  		List<Videos> list = query.getResultList();
  		
  		req.setAttribute("videos", list);
  		req.getRequestDispatcher("/views/index/find.jsp").forward(req, resp);
	}
}
