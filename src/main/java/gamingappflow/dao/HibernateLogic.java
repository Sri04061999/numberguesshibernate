package gamingappflow.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import gamingappflow.dto.Player;
public class HibernateLogic {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("gaming");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void addObject(Player p) {
		transaction.begin();
		manager.persist(p);
		transaction.commit();
	}

	public void fetchObject(String email) {
		Player player = manager.find(Player.class, email);
		System.out.println(player);
	}
	public void deleteObject(String email) {
		Player player = manager.find(Player.class, email);
		transaction.begin();
		manager.remove(player);
		transaction.commit();
	}
	public void updateObject(String email, String newName) {
		Player player = manager.find(Player.class, email);
		player.setName(newName);
		transaction.begin();
		manager.merge(player);
		transaction.commit();
	}
}
