package org.sfsoft.cine.base;

// Generated 22-ene-2014 16:31:59 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "pelicula", catalog = "db_peliculas")
public class Pelicula implements java.io.Serializable {

	private Integer id;
	private Director director;
	private String titulo;
	private Date fechaEstreno;
	private Set<Actor> actores = new HashSet<Actor>(0);

	public Pelicula() {
	}

	public Pelicula(String titulo) {
		this.titulo = titulo;
	}

	public Pelicula(Director director, String titulo, Date fechaEstreno,
			Set<Actor> actors) {
		this.director = director;
		this.titulo = titulo;
		this.fechaEstreno = fechaEstreno;
		this.actores = actors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_director")
	public Director getDirector() {
		return this.director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Column(name = "titulo", nullable = false, length = 300)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_estreno", length = 10)
	public Date getFechaEstreno() {
		return this.fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "actores_peliculas", catalog = "db_peliculas", joinColumns = { @JoinColumn(name = "id_pelicula", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_actor", nullable = false, updatable = false) })
	public Set<Actor> getActors() {
		return this.actores;
	}

	public void setActors(Set<Actor> actors) {
		this.actores = actors;
	}

}
