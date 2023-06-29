package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;
import org.hibernate.envers.*;

@Entity
@Audited
//@AuditTable(value="audit_clientes", schema = "audit")
@Table(name = "tb_clientes", schema = "public")
public class Cliente extends Entidade {
    @Getter @Setter
    @Column(name = "no_cliente", nullable = false, length = 150)
    private String nome;
    @Getter @Setter
    @Column(name = "num_telefone", nullable = false, length=20)
    private String telefone;
    @Getter @Setter
    @Column(name = "no_email", nullable = false, length = 150, unique = true)
    @Email(message = "email inválido.")
    @Size(max = 150, message = "O email não pode ultrpassar 150 caracteres")
    private String email;
    @Getter @Setter
    @Column(name = "num_cep", nullable = false, length = 10)
    private String cep;
    @Getter @Setter
    @Column(name = "tp_logradouro", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeLogradouro tipoLogradouro;
    @Getter @Setter
    @Column(name = "no_logradouro", nullable = false, length = 150)
    @Size(min = 1, max = 150, message = "O nome do logradouro não pode ser menor que um caracter e não pode ultrapassar 150 caracteres.")
    private String logradouro;
    @Getter @Setter
    @Column(name = "num_residencia", length=10)
    private String numResidencia;
    @Getter @Setter
    @Column(name = "no_bairro", nullable = false, length = 150)
    private String bairro;
    @Getter @Setter
    @Column(name = "ds_ptreferencia", length = 300)
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

     /*   public ArrayList<Cliente> listarCliente(ArrayList<Cliente> listar){
            for (Cliente valor:listar) {
                System.out.println("Cliente:"+ valor.getNome() + "\nEmail:"+ valor.getEmail());

            }
        }*/

}
