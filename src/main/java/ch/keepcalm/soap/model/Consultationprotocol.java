package ch.keepcalm.soap.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Consultationprotocol {

    @Id
    String id;
    @NotBlank
    private String sessionId;
    private List <Eintraege> eintraege;
    private List <Karenzfristen> karenzfristen;
}
