package com.co.andes.management.domain.repository.model.database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.annotations.ColumnDefault;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne()
	@JoinColumn(name="product")
	private ProductEntity product;

	@ManyToOne()
	@JoinColumn(name="manufacture")
	private ManufactureEntity manufacture;

	@ManyToOne()
	@JoinColumn(name="importer")
	private ImporterEntity importer;

	@ManyToOne()
	@JoinColumn(name="winery")
	private WineryEntity winery;

	@ManyToOne()
	@JoinColumn(name="category")
	private CategoryEntity category;


	@Column(name = "expiration")
	private String expiration;

	@Column(name = "amount")
	@ColumnDefault("10")
	private long amount;

	@ManyToOne()
	@JoinColumn(name="locate")
	private LocateEntity locate;
}
