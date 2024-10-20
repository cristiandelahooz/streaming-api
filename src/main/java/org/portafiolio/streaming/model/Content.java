package org.portafiolio.streaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "contents")
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String synopsis;
    @Column(nullable = false)
    private boolean available;
    @Column(nullable = false)
    private Date releaseDate;
    @Column(nullable = false)
    private int rating;
    @Column(nullable = false)
    private Long views;
    @Column(nullable = false)
    private String contentType;
    
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    
/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cast_id", referencedColumnName = "cast_id")
    private Cast cast;*/
    
    @JsonIgnore
    @OneToMany(mappedBy = "content")
    private List<Audiovisual> audiovisuals;
    
    
    public Long getViewsByDate(Date beginDate, Date endDate) {
        AtomicLong viewsByDate = new AtomicLong(0L);
        audiovisuals.forEach(audiovisual -> viewsByDate.addAndGet(audiovisual.getHistories().stream().filter(history -> {
            Date date = history.getDate();
            return !date.before(beginDate) && !date.after(endDate);
        }).count()));
        
        return viewsByDate.get();
    }
}
