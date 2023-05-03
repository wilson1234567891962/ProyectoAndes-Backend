package com.co.andes.management.domain.repository.model.database;

import com.co.andes.management.domain.repository.model.database.enums.StateEnum;
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
@Table(name = "deliveryPurchase")
public class DeliveryPurchaseEntity implements Serializable {

	final static Logger logger = Logger.getLogger(DeliveryPurchaseEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "amount")
	@NotNull
	private int  amount;

	@Column( name = "state", columnDefinition = "varchar(255) default 'PROCESSED'")
	@NotNull
	@Enumerated(EnumType.STRING)
	private StateEnum state;

	@OneToOne
	private ClientEntity client;

	@OneToOne
	private UserEntity UserEntity;

	@OneToOne
	private StoreEntity store;


}
