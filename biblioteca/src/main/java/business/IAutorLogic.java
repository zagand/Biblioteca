package business;

import java.util.List;

import model.Autor;

public interface IAutorLogic {

	public List<Autor> getAll();
	public void addAutor(Autor autor);
}
