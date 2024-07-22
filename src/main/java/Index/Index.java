package Index;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import DAO.UserDAO;
import Entity.Videos;
import Entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/index","/detail/*","/error","/favourites"})
public class Index extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (req.getSession().getAttribute("user") != null) {
			Users user = (Users) req.getSession().getAttribute("user");
			req.getSession().setAttribute("name", user.getFullname());
		}
		else {
			req.getSession().setAttribute("name", "Chưa đăng nhập");
		}
		if (uri.contains("index")) {
			this.doLoadIndex(req, resp);
		}
		if (uri.contains("detail")) {
			this.doLoadDetail(req, resp);
		}
		if (uri.contains("error")) {
			this.doError(req, resp);
		}
		if (uri.contains("favourites")) {
			this.doLike(req, resp);
		}
	}
	
	protected void doLoadIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Videos> query = em.createNamedQuery("Videos.findAll", Videos.class);		
		List<Videos> list = query.getResultList();
		
		req.setAttribute("videos", list);
		req.getRequestDispatcher("/views/index/index.jsp").forward(req, resp);
	}
	
	protected void doLoadDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Boolean liked = false;
		List<Videos> listType = null;
     
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
  		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Videos> query = em.createNamedQuery("Videos.findById", Videos.class);
		query.setParameter("videoId", id);
		Videos list = query.getSingleResult();
		
		Query query1 = em.createNamedQuery("Favourites.countLike");
		query1.setParameter("id", id);
		Long likes = (Long) query1.getSingleResult();
		
		if (list.getType().contains("US-UK")) {
			TypedQuery<Videos> query2 = em.createNamedQuery("Videos.findByType", Videos.class);
			String type = "US-UK";
			query2.setParameter("videoType", type);
			query2.setParameter("videoId", id);
			listType = query2.getResultList();
		}
		else if (list.getType().contains("KPOP")) {
			TypedQuery<Videos> query2 = em.createNamedQuery("Videos.findByType", Videos.class);
			String type = "KPOP";
			query2.setParameter("videoType", type);
			query2.setParameter("videoId", id);
			listType = query2.getResultList();
		}
		else if (list.getType().contains("VPOP")) {
			TypedQuery<Videos> query2 = em.createNamedQuery("Videos.findByType", Videos.class);
			String type = "VPOP";
			query2.setParameter("videoType", type);
			query2.setParameter("videoId", id);
			listType = query2.getResultList();
		}
		
		Users user = (Users) req.getSession().getAttribute("user");
		if (user != null) {
			Query query3 = em.createNamedQuery("Favourite.findIsLiked");
			query3.setParameter("videoId", id);
			query3.setParameter("userId", user.getId());
			Long count = (Long) query3.getSingleResult();
			if (count > 0) {
				liked = true;
			}
			else {
				liked = false;
			}
		}
		
		req.setAttribute("liked", liked);
		req.setAttribute("play", list);
		req.setAttribute("likes", likes);
		req.setAttribute("listHint", listType);
		req.getRequestDispatcher("/views/detail/detail.jsp").forward(req, resp);
	}
	
	protected void doError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/404/404.jsp").forward(req, resp);
	}
	
	protected void doLike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") != null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
			EntityManager em = factory.createEntityManager();
			
			Users user = (Users) req.getSession().getAttribute("user");
			
			TypedQuery<Videos> query = em.createNamedQuery("Favourites.findVideoByUserId", Videos.class);
			query.setParameter("id", user.getId());
			List<Videos> list = query.getResultList();
			
			req.setAttribute("videos", list);
			req.getRequestDispatcher("/views/index/like.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/views/account/signin.jsp").forward(req, resp);
		}
	}
}
