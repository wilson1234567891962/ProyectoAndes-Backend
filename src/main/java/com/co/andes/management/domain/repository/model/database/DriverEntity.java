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
@Table(name = "driver")
public class DriverEntity implements Serializable {

	final static Logger logger = Logger.getLogger(DriverEntity.class);
	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "carriagePlate")
	@NotNull
	private String  carriagePlate;

	@Column( name = "driverName")
	@NotNull
	private String  driverName;

	@Column( name = "document")
	@NotNull
	private int  document;
}
