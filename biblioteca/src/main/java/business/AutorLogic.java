package business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;

import repository.IAutorRepository;

@Service
@ManagedBean(name="autorLogic")
@SessionScoped
public class AutorLogic implements IAutorLogic{

	private IAutorRepository autorRepository;
	
	public void setAutorRepository(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
}
