package com.co.andes.management.domain.repository.model.database;
import com.sun.istack.NotNull;
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
@Table(name = "store")
public class StoreEntity implements Serializable {

	final static Logger logger = Logger.getLogger(StoreEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product")
	private ProductEntity product;


	@Column( name = "manufacturer ")
	@NotNull
	private String  manufacturer;

	@Column( name = "importer")
	@NotNull
	private String  importer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category")
	private CategoryEntity category;


	@Column( name = "expiration")
	@NotNull
	private String  expiration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="locate")
	private LocateEntity locate;
}
