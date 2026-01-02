package dev.java10x.CadastroDeNinjas.Missoes.Entity;

import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") //Mapeou e conectou através de uma chave estrangeira
    private List<NinjaModel> ninjas; //Para acessar a tabela de ninja


}
