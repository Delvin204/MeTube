package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.Favourites;
import Entity.Users;
import Entity.Videos;

public class FavouriteDAO {
	public void create(Users user, Videos video) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			// Tạo Entity
			Favourites entity = new Favourites();
			entity.setUser(user);
			entity.setVideo(video);
			entity.setLikeDate(null);
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
}
