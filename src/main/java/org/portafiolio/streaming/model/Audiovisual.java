package org.portafiolio.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.*;
import java.time.Duration;

@Entity
@Table(name = "audiovisuals")
@Data
public class Audiovisual {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long audiovisualId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Duration duration;
	@Column(nullable = false)
	private int season;
	private Date releaseDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "audiovisual")
	private List<History> histories;
	
	@ManyToOne
	@JoinColumn(name = "content_id")
	private Content content;
	
}
