package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entity.Users;

public class UserDAO {
	public void create(Users user) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			// Tạo Entity
			Users entity = new Users();
			entity.setId(user.getId());
			entity.setFullname(user.getFullname());
			entity.setEmail(user.getEmail());
			entity.setPassword(user.getPassword());
			entity.setAdmin(user.getAdmin());
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
	
	public void update(Users user) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction
			// MÃ THAO TÁC
			// Truy vấn thực thể theo id
			Users entity = em.find(Users.class, user.getId());
			// Thay đổi thông tin thực thể
			entity.setEmail(user.getEmail());
			entity.setFullname(user.getFullname());
			entity.setPassword(user.getPassword());
			entity.setId(user.getId());
			entity.setAdmin(user.getAdmin());
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
}
