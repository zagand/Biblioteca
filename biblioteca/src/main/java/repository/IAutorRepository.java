package repository;

import java.util.List;

import model.Autor;


public interface IAutorRepository {

	List<Autor> getAll();

	void addAutor(Autor autor);

}
