package com.co.andes.management.domain.repository.model.database;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product")
	private ProductEntity product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manufacture")
	private ManufactureEntity manufacture;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="importer")
	private ImporterEntity importer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="winery")
	private WineryEntity winery;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category")
	private CategoryEntity category;


	@Column(name = "expiration")
	private String expiration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="locate")
	private LocateEntity locate;
}
