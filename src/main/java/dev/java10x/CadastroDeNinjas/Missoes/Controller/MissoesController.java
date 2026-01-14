package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("hello")
    public String boasVindas(){
        return "Essa é minha missao";
    }

    // GET -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissão(){
        return "Missão criada";
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarTodasAsMissoes(){
        return "Mostrar Missões";
    }

    @GetMapping("/listarID")
    public String listarMissaoPorId(){
        return "Mostrar Missão por ID";
    }

    // PUT -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "Alterar Missão por ID";
    }

    // DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorID(){
        return  "Missão deletada por ID";
    }
}
