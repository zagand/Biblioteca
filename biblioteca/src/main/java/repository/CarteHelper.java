package repository;

import java.util.List;

import model.Carte;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class CarteHelper {
 
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
	public List<Carte> getListOfCarti(int firstRow, int rowCount) {
        List<Carte> carteList = null;
        try {
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carte.class);
            criteria.setFirstResult(firstRow);
            criteria.setMaxResults(rowCount);
            if (criteria != null) {
            	carteList = (List<Carte>) criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carteList;
    }
 
    public int countRows() {
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carte.class);
            if (criteria != null) {
                return criteria.list().size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
