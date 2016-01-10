package model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToMany
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
	
}
