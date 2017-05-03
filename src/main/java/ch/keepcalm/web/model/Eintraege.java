package ch.keepcalm.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Eintraege {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String erstellt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date akzeptiert;
    private String eintragKunde;
    private String eintragBerater;
    private Berater berater;
}
