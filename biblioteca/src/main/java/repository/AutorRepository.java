package repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AutorRepository implements IAutorRepository{

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
}
