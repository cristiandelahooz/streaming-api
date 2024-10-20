package org.portafiolio.streaming.model;

import jakarta.persistence.*;
import lombok.Data;
import org.portafiolio.streaming.model.compositeprimarykey.HistoryPK;

import java.sql.Date;
import java.time.Duration;

@Entity
@IdClass(HistoryPK.class)
@Table(name = "histories")
@Data
public class History {
	@Id
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name = "audiovisual_id")
	private Audiovisual audiovisual;
	@Id
	private Date date;
	@Column(nullable = false)
	private Duration timeWatched;
}
