package dev.java10x.CadastroDeNinjas.Missoes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String dificuldade;

    // Uuma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") //Mapeou e conectou através de uma chave estrangeira
    @JsonIgnore
    private List<NinjaModel> ninjas; //Para acessar a tabela de ninja


}
