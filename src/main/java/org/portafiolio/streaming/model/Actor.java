package org.portafiolio.streaming.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "actors")
@Data
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long actorId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	

}
