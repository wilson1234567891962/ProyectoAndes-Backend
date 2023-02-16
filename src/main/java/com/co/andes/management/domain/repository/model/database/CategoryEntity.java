package com.co.andes.management.domain.repository.model.database;

import com.co.andes.management.domain.repository.model.database.enums.CategoryEnum;
import com.co.andes.management.domain.repository.model.database.enums.RolesEnum;
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
@Table(name = "category")
public class CategoryEntity implements Serializable {

	final static Logger logger = Logger.getLogger(CategoryEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@Column(name = "id")
	private Integer id;


	@Column( name = "category", length = 30)
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

	@Column( name = "description", length = 200)
	@NotNull
	private String  description;

	@OneToMany(mappedBy="category")
	private List<StoreEntity> categoryList;



}
