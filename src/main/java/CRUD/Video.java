package CRUD;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DAO.VideoDAO;
import Entity.Videos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig()
@WebServlet({"/video","/video/create","/video/update","/video/delete","/video/clear"})
public class Video extends HttpServlet{
	Videos selected;
	List<Videos> list;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Assignment");
  		EntityManager em = factory.createEntityManager();
		
		String id = req.getParameter("id");
		if (id != null) {
			TypedQuery<Videos> query = em.createNamedQuery("Videos.findById", Videos.class);
			query.setParameter("videoId", id);
			selected = query.getSingleResult();
			
			req.setAttribute("edit", selected);
		}
		
		TypedQuery<Videos> query1 = em.createNamedQuery("Videos.findAllAdmin", Videos.class);		
		list = query1.getResultList();
		
		req.setAttribute("videos", list);
		
		req.getRequestDispatcher("/views/crud/video.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();
		File photoFile = null;
		File videoFile = null;
		
		File dirImg = new File(req.getServletContext().getRealPath("Asignment/src/main/webapp/image/thumbnail"));
		File dirVideo = new File(req.getServletContext().getRealPath("Asignment/src/main/webapp/video"));
		
		Part photoPart = req.getPart("poster"); // file hình
	    if (photoPart != null && photoPart.getSize() > 0 && photoPart.getContentType().startsWith("image")) {
	        photoFile = new File(dirImg, photoPart.getSubmittedFileName());
	        photoPart.write(photoFile.getAbsolutePath());
	    }
	    
	    Part videoPart = req.getPart("url"); // file tài liệu
	    if (videoPart != null && videoPart.getSize() > 0) {
	        videoFile = new File(dirVideo, videoPart.getSubmittedFileName());
	        videoPart.write(videoFile.getAbsolutePath());
	    }
		
		try {
			Videos video = new Videos();
			video.setId(req.getParameter("id"));
			video.setTitle(req.getParameter("title"));
			video.setPoster(photoFile != null ? photoFile.toString() : null);
			video.setActive(req.getParameter("status").equals("active")?true:false);
			video.setUrl(videoFile != null ? videoFile.toString() : null);
			// Kiểm tra xem chuỗi views có giá trị hay không trước khi chuyển đổi
	        String viewsStr = req.getParameter("views");
	        int views = 0; // Giá trị mặc định nếu viewsStr là null hoặc không hợp lệ
	        if (viewsStr != null && !viewsStr.isEmpty()) {
	            views = Integer.parseInt(viewsStr);
	        }
	        video.setViews(views);
			video.setOwner(req.getParameter("owner"));
			video.setDescription(req.getParameter("description"));
			video.setType(req.getParameter("type"));
			
			String uri = req.getRequestURI();
			if (uri.contains("create")) {
				for (Videos videos : list) {
					if (videos.getId().equals(video.getId())) {
						req.setAttribute("messVideo", "Thêm video thất bại, Video Id này đã tồn tại");
						video.setId("");
						req.setAttribute("edit", video);
						req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
						return;
					}
				}
				if (video.getPoster() == null) {
					req.setAttribute("messVideo", "Thêm video thất bại, vui lòng chọn Poster");
					req.setAttribute("edit", video);
					req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
					return;
				}
				if (video.getUrl() == null) {
					req.setAttribute("messVideo", "Thêm video thất bại, vui lòng chọn Video");
					req.setAttribute("edit", video);
					req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
					return;
				}
				dao.create(video);
				req.setAttribute("messVideo", "Thêm video thành công");
				req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
				return;
			}
			if (uri.contains("update")) {
				if (video.getPoster() == null) {
					video.setPoster(selected.getPoster());
				}
				if (video.getUrl() == null) {
					video.setUrl(selected.getUrl());
				}
				
				try {
					dao.update(video);
				} catch (Exception e) {
					System.out.println(e);
				}
				
				req.setAttribute("messVideo", "Sửa video thành công");
				req.setAttribute("edit", video);
				req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
//				return;
			}
			if (uri.contains("delete")) {
				if (video.getId() == null) {
					req.setAttribute("messVideo", "Xóa video thất bại, vui lòng nhập Video Id");
					req.setAttribute("edit", video);
					req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
					return;
				}
				dao.delete(video.getId());
				req.setAttribute("messVideo", "Xóa video thành công");
				req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
				return;
			}
			if (uri.contains("clear")) {
//				req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
				doGet(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			req.setAttribute("messVideo", "Thêm video thất bại");
			req.getRequestDispatcher("/views/crud/video2.jsp").forward(req, resp);
//			return;
		}
	}
}
