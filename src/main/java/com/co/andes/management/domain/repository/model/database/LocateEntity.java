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
@Table(name = "locate")
public class LocateEntity implements Serializable {

	final static Logger logger = Logger.getLogger(LocateEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@Column( name = "address")
	@NotNull
	private String  address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country")
	private CountryEntity country;

	@OneToMany(mappedBy="locate")
	private List<StoreEntity> locates;



}
