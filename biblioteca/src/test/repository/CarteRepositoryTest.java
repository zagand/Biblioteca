package repository;


import java.util.List;

import model.Carte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@Transactional
public class CarteRepositoryTest {

	ICarteRepository carteRepository;
	
	public void setCarteRepository(ICarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }
	
	@Test
	public void testAddAndGet() {
		Carte carte = new Carte();
		carte.setAn_aparitie(2015);
		carte.setCota("cota_test");
		carte.setEditura("editura test");
		carteRepository.addCarte(carte);
		List<Carte> carti = carteRepository.getAll();
		Assert.isTrue(carti.contains(carte));
		
	}
	
	@Test
	public void testDelete() {
		Carte carte = new Carte();
		carte.setAn_aparitie(2015);
		carte.setCota("cota_test");
		carte.setEditura("editura test");
		carteRepository.deleteCarte(carte);
		List<Carte> carti = carteRepository.getAll();
		Assert.isTrue(!carti.contains(carte));
		
	}

}
