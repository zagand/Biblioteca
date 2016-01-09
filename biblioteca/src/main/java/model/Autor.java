package model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
@ManagedBean(name="autor")
public class Autor {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nume")
	private String nume;
	
	@ManyToMany(mappedBy = "autori")
	private List<Carte> carti;

	public List<Carte> getCarti() {
		return carti;
	}

	public void setCarti(List<Carte> carti) {
		this.carti = carti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	
}
