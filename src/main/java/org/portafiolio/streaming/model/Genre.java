package org.portafiolio.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Entity
@Table(name = "genres")
@Data
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int ageRating;
	
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Content> contents;
}
