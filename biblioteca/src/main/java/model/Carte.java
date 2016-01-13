package model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "carte")
@ManagedBean(name="carte")
public class Carte {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column(name = "id")
	private int carte_id;
	
	@Column(name = "cota")
	private String cota;

	@Column(name = "titlu")
	private String titlu;

	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "editura")
	private String editura;

	@Column(name = "loc_aparitie")
	private String loc_aparitie;

	@Column(name = "observatii")
	private String observatii;
	
	@Column(name = "an_aparitie")
	private int an_aparitie;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "carte_autor", joinColumns = {@JoinColumn(name = "carte_id")},
			inverseJoinColumns = {@JoinColumn(name = "autor_id")})
	private List<Autor> autori;

	public List<Autor> getAutori() {
		return autori;
	}

	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	public int getId() {
		return carte_id;
	}

	public void setId(int id) {
		this.carte_id = id;
	}
	
	public String getCota() {
		return cota;
	}

	public void setCota(String cota) {
		this.cota = cota;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getLoc_aparitie() {
		return loc_aparitie;
	}

	public void setLoc_aparitie(String loc_aparitie) {
		this.loc_aparitie = loc_aparitie;
	}

	public String getObservatii() {
		return observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}

	public int getAn_aparitie() {
		return an_aparitie;
	}

	public void setAn_aparitie(int an_aparitie) {
		this.an_aparitie = an_aparitie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + an_aparitie;
		result = prime * result + ((autori == null) ? 0 : autori.hashCode());
		result = prime * result + carte_id;
		result = prime * result + ((cota == null) ? 0 : cota.hashCode());
		result = prime * result + ((editura == null) ? 0 : editura.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((loc_aparitie == null) ? 0 : loc_aparitie.hashCode());
		result = prime * result
				+ ((observatii == null) ? 0 : observatii.hashCode());
		result = prime * result + ((titlu == null) ? 0 : titlu.hashCode());
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
		Carte other = (Carte) obj;
		if (an_aparitie != other.an_aparitie)
			return false;
		if (autori == null) {
			if (other.autori != null)
				return false;
		} else if (!autori.equals(other.autori))
			return false;
		if (carte_id != other.carte_id)
			return false;
		if (cota == null) {
			if (other.cota != null)
				return false;
		} else if (!cota.equals(other.cota))
			return false;
		if (editura == null) {
			if (other.editura != null)
				return false;
		} else if (!editura.equals(other.editura))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (loc_aparitie == null) {
			if (other.loc_aparitie != null)
				return false;
		} else if (!loc_aparitie.equals(other.loc_aparitie))
			return false;
		if (observatii == null) {
			if (other.observatii != null)
				return false;
		} else if (!observatii.equals(other.observatii))
			return false;
		if (titlu == null) {
			if (other.titlu != null)
				return false;
		} else if (!titlu.equals(other.titlu))
			return false;
		return true;
	}
	
}
