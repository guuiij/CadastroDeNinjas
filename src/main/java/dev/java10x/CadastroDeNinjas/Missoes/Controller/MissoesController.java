package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("hello")
    public String boasVindas(){
        return "Essa é minha missao";
    }

    // GET -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    // GET -- Mandar uma requisição para mostrar todas as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarTodasAsMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return  missoesService.listarMissaoPorId(id);

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
