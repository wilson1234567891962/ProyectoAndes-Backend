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
@Table(name = "audit")
public class AuditEntity implements Serializable {

	final static Logger logger = Logger.getLogger(AuditEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column( name = "token")
	@NotNull
	private String  token;

	@Column( name = "description")
	@NotNull
	@Enumerated(EnumType.STRING)
	private EventEnum description;


	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date time;



}
