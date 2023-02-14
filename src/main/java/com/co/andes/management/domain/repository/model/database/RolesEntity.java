package com.co.andes.management.domain.repository.model.database;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RolesEntity implements Serializable {

	final static Logger logger = Logger.getLogger(RolesEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@Column(name = "id")
	private Integer id;


	@Column( name = "rol", length = 30)
	@NotNull
	private String  rol;

	@Column( name = "description", length = 200)
	@NotNull
	private String  description;

	@OneToMany(mappedBy="rol")
	private List<UserEntity> userList;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
