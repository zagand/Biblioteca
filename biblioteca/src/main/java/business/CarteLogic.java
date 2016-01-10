package business;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Carte;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.ICarteRepository;

@Service
@ManagedBean(name="carteLogic")
@SessionScoped
public class CarteLogic implements ICarteLogic {

	private ICarteRepository carteRepository;
	
	public void setCarteRepository(ICarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }
	
    @Transactional
	public List<Carte> getAll() {
		return carteRepository.getAll();
	}

    @Transactional
	public void addCarte(Carte carte) {
		carteRepository.addCarte(carte);
		
	}

	public void deleteCarte(Carte carte) {
		carteRepository.deleteCarte(carte);
	}

}
