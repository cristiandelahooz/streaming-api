package org.portafiolio.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language languageId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<History> histories;
	
}
