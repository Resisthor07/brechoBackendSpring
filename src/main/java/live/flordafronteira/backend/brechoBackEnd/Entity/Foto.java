package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
@Entity
@Table(name = "tb_imagens", schema="public")
public class Foto extends Entidade{
    @Getter @Setter
    @Column(name = "imagem", nullable = false)
    private BufferedImage imagem;
    @Getter @Setter
    @Column(name = "st_principal", nullable = false)
    private boolean imagemPrincipal;
    @Getter @Setter
    @Column(name = "st_carrossel", nullable = false)
    private boolean compoeCarrossel;

}
