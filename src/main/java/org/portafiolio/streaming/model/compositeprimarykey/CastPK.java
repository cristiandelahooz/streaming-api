package org.portafiolio.streaming.model.compositeprimarykey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.portafiolio.streaming.model.Actor;
import org.portafiolio.streaming.model.Content;

import java.io.Serializable;

@EqualsAndHashCode
@Data
public class CastPK implements Serializable {
    private Content content;
    private Actor actor;
    
}
