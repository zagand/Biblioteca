package business;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import model.Autor;
import model.Carte;

public interface ICarteLogic {
	
	public boolean isOrdered();
	public void setOrdered(boolean ordered);
	public void updateCheck(AjaxBehaviorEvent event);
	public List<Carte> getAll();
	public void addCarte(Carte carte);
	public void deleteCarte(Carte carte);
	public List<Carte> getOredered();
	public void addAutorToCarte(Carte carte, Autor autor);
	public Autor findAutorById(int id);
	public List<String> getAutori();
	public void setAutori(List<String> autori);
}
