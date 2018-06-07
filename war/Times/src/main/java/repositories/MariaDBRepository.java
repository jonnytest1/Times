package repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app.model.Time;

@Stateless
public class MariaDBRepository {

	@PersistenceContext(unitName = "mariaDatasource")
	public EntityManager entityManager;

	@PersistenceContext(unitName = "mariaCDB")
	public EntityManager entityCreate;

	public MariaDBRepository() {
		super();
	}

	public <T> T save(T obj) {
		try {
			entityManager.persist(obj);
		} catch (Exception e) {
			if (e.getMessage().contains("exist")) {
				try {
					entityCreate.persist(obj);
				} catch (Exception b) {
					b.printStackTrace();
				}

			}
		}
		return obj;
	}

	public List<Time> getTimes() {
		List<Time> list = null;
		try {
			list = entityManager.createQuery("SELECT c FROM Time c", Time.class).getResultList();
		} catch (Exception e) {
			try {
				entityCreate.persist(new Time("date", "date", "date", "date", "date", "date", "date"));
				list = entityManager.createQuery("SELECT c FROM Time c", Time.class).getResultList();
			} catch (Exception b) {
				b.printStackTrace();
			}
		}
		return list;
	}

}
