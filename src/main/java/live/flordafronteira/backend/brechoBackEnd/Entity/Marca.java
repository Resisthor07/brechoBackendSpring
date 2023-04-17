package live.flordafronteira.backend.brechoBackEnd.View.Entity;

import jakarta.persistence.*;
import live.flordafronteira.backend.brechoBackEnd.View.Entity.Entitty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_marca", schema= "public")
public class Marca extends Entitty {
    @Getter
    @Setter
    @Column(name="no_marca", nullable=false, unique=true, length=100)
    private String marca;


}
