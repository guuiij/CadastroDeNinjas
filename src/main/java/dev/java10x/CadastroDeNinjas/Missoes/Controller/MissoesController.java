package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import dev.java10x.CadastroDeNinjas.Missoes.dto.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return missoesService.criarMissao(missao);
    }

    // GET -- Mandar uma requisição para mostrar todas as missões
    @GetMapping("/listar")
    public List<MissaoDTO> listarTodasAsMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);

    }

    // PUT -- Mandar uma requisição para alterar a missão
    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissaoDTO atualizarMissao) {
        return missoesService.alterarMissaoPorId(id, atualizarMissao);
    }

    // DELETE -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorID(@PathVariable Long id) {
        missoesService.deletarMissaoPorID(id);
    }
}
