package org.portafiolio.streaming.model.report;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Top10ContentReport {
    private String type;
    private String title;
    private String synopsis;
    private String year;
    private Long reproductions;
}
