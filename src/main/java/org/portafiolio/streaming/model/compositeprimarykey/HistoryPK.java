package org.portafiolio.streaming.model.compositeprimarykey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.portafiolio.streaming.model.Audiovisual;
import org.portafiolio.streaming.model.User;

import java.io.Serializable;
import java.sql.Date;


@EqualsAndHashCode
@Data
public class HistoryPK implements Serializable {
    
    private User user;
    private Audiovisual audiovisual;
    private Date date;
    
}
