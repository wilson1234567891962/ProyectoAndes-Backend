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
@Table(name = "client")
public class ClientEntity implements Serializable {

	final static Logger logger = Logger.getLogger(ClientEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "names")
	@NotNull
	private String  names;

	@Column( name = "surnames")
	@NotNull
	private String  surnames;

	@Column( name = "address")
	@NotNull
	private String  address;

	@Column( name = "phone")
	@NotNull
	private String  phone;


	@Column( name = "finance")
	@NotNull
	private String  finance;


}
