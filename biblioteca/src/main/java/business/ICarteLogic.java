package business;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import model.Carte;

public interface ICarteLogic {
	
	public boolean isOrdered();
	public void setOrdered(boolean ordered);
	public void updateCheck(AjaxBehaviorEvent event);
	public List<Carte> getAll();
	public void addCarte(Carte carte);
	public void deleteCarte(Carte carte);
	public List<Carte> getOredered();
}
