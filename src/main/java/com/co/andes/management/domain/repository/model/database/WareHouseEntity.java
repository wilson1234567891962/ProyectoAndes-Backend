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
@Table(name = "warehouse")
public class WareHouseEntity implements Serializable {

	final static Logger logger = Logger.getLogger(WareHouseEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "name", length = 200)
	@NotNull
	private String  name;

	@OneToMany(mappedBy="warehouse")
	private List<StoreEntity> winery;

}
