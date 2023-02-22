package com.co.andes.management.domain.repository.model.database;

import com.co.andes.management.domain.repository.model.database.enums.RolesEnum;
import com.co.andes.management.domain.repository.model.database.enums.StateEnum;
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
@Table(name = "orderPurchase")
public class OrderPurchaseEntity implements Serializable {

	final static Logger logger = Logger.getLogger(OrderPurchaseEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "amount")
	@NotNull
	private int  amount;

	@Column( name = "state", columnDefinition = "varchar(255) default 'PENDING'")
	@NotNull
	@Enumerated(EnumType.STRING)
	private StateEnum state;

	@ManyToMany
	private List<ClientEntity> client;

	@ManyToMany
	private List<UserEntity> UserEntity;

	@ManyToMany
	private List<StoreEntity> store;

}
