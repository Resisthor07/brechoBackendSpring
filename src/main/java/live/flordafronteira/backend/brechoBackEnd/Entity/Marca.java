package live.flordafronteira.backend.brechoBackEnd.View.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Table(name="tb_marca", schema= "public")
public class Marca extends live.flordafronteira.backend.brechoBackEnd.View.Entity.Entity {
    @Getter
    @Setter
    @Column(name="no_marca", nullable=false, unique=true, length=100)
    private String marca;


}
