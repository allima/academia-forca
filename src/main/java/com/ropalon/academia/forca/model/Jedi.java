package com.ropalon.academia.forca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jedi")
public class Jedi {

	@Id
	@Column(name = "id_jedi")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres")
	@NotBlank(message = "Nome não pode estar em branco")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Sobrenome não pode estar em branco")
	@Column(name = "last_name")
	private String lastName;

	public Jedi(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Jedi() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
