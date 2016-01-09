package business;

import java.util.List;

import model.Carte;

public interface ICarteLogic {

	public List<Carte> getAll();
	public void addCarte(Carte carte);
	public void deleteCarte(Carte carte);
}
