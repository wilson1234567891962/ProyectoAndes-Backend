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
@Table(name = "importer")
public class ImporterEntity implements Serializable {

	final static Logger logger = Logger.getLogger(ImporterEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@Column( name = "name", length = 200)
	@NotNull
	private String  name;

	@OneToMany(mappedBy="importer")
	private List<StoreEntity> importer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country")
	private CountryEntity country;

}
