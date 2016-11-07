package gdg.eskisehir.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Samet Sevim on 5.10.2016.
 */
@Entity
@Data
public class Participant {

    @Id
    @GeneratedValue
    Long id;

    String username;
    String firstname;
    String lastname;
    int age;


}
