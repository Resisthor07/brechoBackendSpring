package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass

public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;
    @Getter @Setter
    @Column(name = "dt-criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @Getter @Setter
    @Column(name = "dt-atualizacao", nullable = false)
    private LocalDateTime dataModificacao;
    @Getter @Setter
    @Column(name = "st ativo", nullable = false)
    private boolean status;

    public void prePersist(){
        this.dataCriacao=LocalDateTime.now();
        this.status=true;
    }

    public void preUpadte(){
        this.dataModificacao=LocalDateTime.now();
    }




}
