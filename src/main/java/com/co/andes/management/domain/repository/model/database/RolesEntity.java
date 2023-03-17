package com.co.andes.management.domain.repository.model.database;

import com.co.andes.management.domain.repository.model.database.enums.RolesEnum;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@Column( name = "rol", length = 30)
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolesEnum rol;

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

	public RolesEnum getRol() {
		return rol;
	}

	public void setRol(RolesEnum rol) {
		this.rol = rol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
