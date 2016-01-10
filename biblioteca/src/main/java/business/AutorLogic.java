package business;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Autor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.IAutorRepository;

@Service
@ManagedBean(name="autorLogic")
@SessionScoped
public class AutorLogic implements IAutorLogic{

	private IAutorRepository autorRepository;
	
	public void setAutorRepository(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
	
    @Transactional
	public List<Autor> getAll() {
		return autorRepository.getAll();
	}

    @Transactional
	public void addAutor(Autor autor) {
		autorRepository.addAutor(autor);
	}

}
