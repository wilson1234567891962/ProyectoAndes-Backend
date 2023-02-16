package com.co.andes.management.domain.repository.model.database;

import com.co.andes.management.domain.repository.model.database.enums.CategoryEnum;
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
	@Column(name = "id")
	private Integer id;


	@Column( name = "locate", length = 200)
	@NotNull
	private String  locate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country")
	private CountryEntity country;

	@OneToMany(mappedBy="locate")
	private List<StoreEntity> storeEntity;



}
