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
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne um ninja tem uma única missão.
    @ManyToOne
    // Juntar as duas colunas ( gera uma terceira coluna -> "missoes_id" )
    @JoinColumn(name = "missoes_id")  // Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}
