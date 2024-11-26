package ak2.services.ak2.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "authorities")
@Data
public class UserAuthority implements Serializable {
     @Id
     private Integer id = 2;

     private String name = "BASIC";
}
