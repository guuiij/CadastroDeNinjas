package dev.java10x.CadastroDeNinjas.Ninjas.Entity;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

// Entity transforma uma classe em uma entidade do BD
// JPA – Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (unique = true)
    private String email;

    @Column (name = "IMG_URL")
    private String imagemURL;

    @Column (name = "idade")
    private int idade;

    @Column (name = "rank")
    private String rank;

    // @ManyToOne um ninja tem uma única missão.
    @ManyToOne
    // Juntar as duas colunas ( gera uma terceira coluna -> "missoes_id" )
    @JoinColumn (name = "missoes_id")  // Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}
