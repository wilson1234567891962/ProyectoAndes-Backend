package com.co.andes.management.domain.repository.model.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	final static Logger logger = Logger.getLogger(UserEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;


	@Column( name = "email", length = 1000000)
	private String  email;

	@Column( name = "pasword", length = 1000000)
	private String  password;

	@Column( name = "pasword", length = 1000000)
	private String  roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
