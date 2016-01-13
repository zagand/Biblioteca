package business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import model.Autor;
import model.Carte;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.ICarteRepository;

@Service
@ManagedBean(name="carteLogic")
@SessionScoped
public class CarteLogic implements ICarteLogic {

	private ICarteRepository carteRepository;
	private List<String> autori;
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
    	
    	List<Autor> autori = new ArrayList<Autor>();
    	for (String id : getAutori()) {
			autori.add(carteRepository.findAutorById(Integer.parseInt(id)));
		}
    	carte.setAutori(autori);
		carteRepository.addCarte(carte);
		
	}
    
    @Transactional
    public Autor findAutorById(int id) {
    	return carteRepository.findAutorById(id);
    }
	
	@Transactional
	public void deleteCarte(Carte carte) {
		carteRepository.deleteCarte(carte);
	}

	public void addAutorToCarte(Carte carte, Autor autor) {
		if(carte.getAutori() == null) {
			List<Autor> autori = new ArrayList<Autor>();
			autori.add(autor);
			carte.setAutori(autori);
		} else {
			carte.getAutori().add(autor);
		}
	}
	
	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> autori) {
		this.autori = autori;
	}
}
