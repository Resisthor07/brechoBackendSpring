package live.flordafronteira.backend.brechoBackEnd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente extends Entitty {
    @Getter @Setter
    @Column(name = "nm-cliente", nullable = false, length = 150)
    private String nome;
    @Getter @Setter
    @Column(name = "num-telefone", nullable = false)
    private String telefone;
    @Getter @Setter
    @Column(name = "nm-email", nullable = false, length = 150)
    private String email;
    @Getter @Setter
    @Column(name = "tp-logradouro", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeLogradouro tipoLogradouro;
    @Getter @Setter
    @Column(name = "nm-logradouro", nullable = false, length = 150)
    private String logradouro;
    @Getter @Setter
    @Column(name = "num-residencia", nullable = false)
    private int numResidencia;
    @Getter @Setter
    @Column(name = "nm-bairro", nullable = false, length = 150)
    private String bairro;
    @Getter @Setter
    @Column(name = "ds-ptreferencia", nullable = false, length = 300)
    private String pontoReferencia;


    public boolean addCliente(){
        Scanner ler = new Scanner(System.in);
        boolean repete = false;
        System.out.println("Informe seu nome:");
        nome= ler.next();
        ler.nextLine();
        System.out.println("Informe o seu email:");
        email= ler.next();
        ler.nextLine();
        System.out.println("Informe seu logradouro:");
        logradouro= ler.next();
        ler.nextLine();
        System.out.println("Informe seu bairro:");
        bairro= ler.next();
        ler.nextLine();
        System.out.println("Gostaria de cadastrar um novo cliente?\n (S) Sim (N) Não:");
        repete = newCliente(ler.next());
        ler.nextLine();
        return repete;

    }

    public boolean newCliente(String add){
        if(add.equalsIgnoreCase("S")){
            return true;
        }else return false;
    }


}
