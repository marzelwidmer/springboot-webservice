package ch.keepcalm.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Karenzfristen {

    private int tage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginn;
    private String referenz;

}
