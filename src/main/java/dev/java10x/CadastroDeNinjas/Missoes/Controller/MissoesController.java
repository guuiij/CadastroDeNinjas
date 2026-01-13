package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("hello")
    public String boasVindas(){
        return "Essa é minha missao";
    }

    @PostMapping("/criar")
    public String criarMissão(){
        return "Missão criada";
    }

    @GetMapping("/todos")
    public String mostrarTodasAsMissoes(){
        return "Mostrar Missões";
    }

    @GetMapping("/todosID")
    public String mostrarMissaoPorId(){
        return "Mostrar Missão por ID";
    }

    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "Alterar Missão por ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoPorID(){
        return  "Missão deletada por ID";
    }
}
