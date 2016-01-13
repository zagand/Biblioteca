package model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
@ManagedBean(name="autor")
public class Autor {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column(name = "id")
	private int autor_id;
	
	@Column(name = "nume")
	private String nume;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "autori")
	private List<Carte> carti;

	public List<Carte> getCarti() {
		return carti;
	}

	public void setCarti(List<Carte> carti) {
		this.carti = carti;
	}

	public int getId() {
		return autor_id;
	}

	public void setId(int id) {
		this.autor_id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autor_id;
		result = prime * result + ((carti == null) ? 0 : carti.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (autor_id != other.autor_id)
			return false;
		if (carti == null) {
			if (other.carti != null)
				return false;
		} else if (!carti.equals(other.carti))
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}
	
}
