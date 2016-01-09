package repository;

import java.util.List;

import model.Carte;

public interface ICarteRepository {
	public List<Carte> getAll();
	public void addCarte(Carte carte);
	public void deleteCarte(Carte carte);
}
