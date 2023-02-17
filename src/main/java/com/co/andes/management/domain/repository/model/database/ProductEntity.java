package com.co.andes.management.domain.repository.model.database;
import com.co.andes.management.domain.repository.model.database.enums.EventEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	final static Logger logger = Logger.getLogger(ProductEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@Column( name = "name")
	@NotNull
	private String name;

	@Column( name = "image")
	private String image;

	@OneToMany(mappedBy="product")
	private List<StoreEntity> product;


}
