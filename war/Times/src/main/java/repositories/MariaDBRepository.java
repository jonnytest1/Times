package repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import app.model.Calendar;
import app.model.Time;

@Stateless
public class MariaDBRepository {

	@PersistenceContext(unitName = "mariaDatasource")
	public EntityManager entityManager;

	public MariaDBRepository() {
		super();
	}

	public <T> T save(T obj) {
		entityManager.persist(obj);

		return obj;
	}

	public List<Time> getTimes() {
		List<Time> list = null;
		list = entityManager.createQuery("SELECT c FROM Time c", Time.class).getResultList();
		return list;
	}

	public List<Calendar> getCalender() {
		List<Calendar> list = null;
		try {
			list = entityManager.createQuery("SELECT c FROM Calendar c", Calendar.class).getResultList();
		} catch (Exception e) {
		}
		return list;
	}

}
