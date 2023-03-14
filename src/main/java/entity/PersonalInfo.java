package entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Embeddable
@ToString
public class PersonalInfo {

    private String firstname;
    private String lastName;
    private LocalDate birthDate;
    private Integer age;

}
