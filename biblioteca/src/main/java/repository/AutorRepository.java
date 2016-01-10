package repository;

import java.util.List;

import model.Autor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AutorRepository implements IAutorRepository{

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @SuppressWarnings("unchecked")
	public List<Autor> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Autor> autoriList = session.createQuery("from Autor").list();

        return autoriList;
	}

	public void addAutor(Autor autor) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(autor);
	}
}
