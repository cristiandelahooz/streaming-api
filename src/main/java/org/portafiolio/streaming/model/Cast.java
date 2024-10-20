package org.portafiolio.streaming.model;

import jakarta.persistence.*;
import lombok.Data;
import org.portafiolio.streaming.model.compositeprimarykey.CastPK;

@Entity
@IdClass(CastPK.class)
@Table(name = "casts")
@Data
public class Cast {
    @Id
    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

}
