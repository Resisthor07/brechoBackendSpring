package live.flordafronteira.backend.brechoBackEnd.Entity.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass

public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;
    @Getter @Setter
    @Column(name = "dt-criacao", nullable = false)
    protected LocalDateTime criacao;
    @Getter @Setter
    @Column(name = "dt-atualizacao", nullable = false)
    protected LocalDateTime edicao;
    @Getter @Setter
    @Column(name = "st ativo", nullable = false)
    protected boolean ativo;

    public void prePersist(){
        this.criacao=LocalDateTime.now();
        this.ativo=true;
    }

    public void preUpadte(){
        this.edicao=LocalDateTime.now();
    }




}
