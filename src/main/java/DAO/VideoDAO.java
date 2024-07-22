package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.Videos;

public class VideoDAO {
	public void create(Videos video) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			// Tạo Entity
			Videos entity = new Videos();
			entity.setId(video.getId());
			entity.setTitle(video.getTitle());
			entity.setPoster(video.getPoster());
			entity.setDescription(video.getDescription());
			entity.setViews(video.getViews());
			entity.setActive(video.getActive());
			entity.setOwner(video.getOwner());
			entity.setUrl(video.getUrl());
			entity.setType(video.getType());
			// Insert vào CSDL
			em.persist(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("Add success");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Add fail");
		}
		em.close();
		emf.close();
	}
	
	public void update(Videos video) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			// Truy vấn thực thể theo id
			Videos entity = new Videos();
			entity.setId(video.getId());
			entity.setTitle(video.getTitle());
			entity.setPoster(video.getPoster());
			entity.setDescription(video.getDescription());
			entity.setViews(video.getViews());
			entity.setActive(video.getActive());
			entity.setOwner(video.getOwner());
			entity.setUrl(video.getUrl());
			entity.setType(video.getType());
			// Cập nhật thực thể
			em.merge(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("Update success");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Update fail");
			System.out.println(e);
		}
		em.close();
		emf.close();
	}
	
	public void delete(String id) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("L5PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			Videos entity = em.find(Videos.class, id);
			em.remove(entity);
			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("Delete success");
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Delete fail");
		}
		em.close();
		emf.close();
	}
}
