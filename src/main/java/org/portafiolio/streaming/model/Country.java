package org.portafiolio.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Entity
@Table(name = "countries")
@Data
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "country")
	private List<Content> contents;
	
}
