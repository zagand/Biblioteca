package business;

import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import model.Carte;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.ICarteRepository;

@Service
@ManagedBean(name="carteLogic")
@SessionScoped
public class CarteLogic implements ICarteLogic {

	private ICarteRepository carteRepository;
	private boolean ordered = false;
	
	public void setCarteRepository(ICarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }
	
	public boolean isOrdered() {
		return ordered;
	}
	
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}
	
	public void updateCheck(AjaxBehaviorEvent event) {
		setOrdered(!ordered);
	}  
	
    @Transactional
	public List<Carte> getAll() {
		return carteRepository.getAll();
	}
    
    @Transactional
	public List<Carte> getOredered() {
    	
    	List<Carte> carti = carteRepository.getAll();
    	Comparator<Carte> comp = new Comparator<Carte>() {
			
			@Override
			public int compare(Carte arg0, Carte arg1) {
				
				return Integer.compare(arg0.getAn_aparitie(), arg1.getAn_aparitie());
			}
		};
		
		carti.sort(comp);
    	return carti;
    }

    @Transactional
	public void addCarte(Carte carte) {
		carteRepository.addCarte(carte);
		
	}
	
	@Transactional
	public void deleteCarte(Carte carte) {
		carteRepository.deleteCarte(carte);
	}

}
