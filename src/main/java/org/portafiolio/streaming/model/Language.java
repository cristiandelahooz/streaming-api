package org.portafiolio.streaming.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "languages")
@Data
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idiomaId;
	@Column(nullable = false)
	private String name;
	
}
