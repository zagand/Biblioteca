package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.Carte;

@Repository
public class CarteRepository implements ICarteRepository {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@SuppressWarnings("unchecked")
	public List<Carte> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Carte> cartiList = session.createQuery("from Carte").list();

        return cartiList;
	}

	public void addCarte(Carte carte) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(carte);
	}

	public void deleteCarte(Carte carte) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(carte);
	}

}
