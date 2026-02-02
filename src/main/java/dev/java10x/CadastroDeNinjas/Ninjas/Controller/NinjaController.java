package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinjaDTO.getNome() + " (ID): " + novoNinjaDTO.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarTodosOsNInjas() {
        List<NinjaDTO> responseNinjaDTO = ninjaService.listarNinjas();
         return ResponseEntity.ok( responseNinjaDTO);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            NinjaDTO ninjaPorIdDTO = ninjaService.listarNinjaPorId(id);
            return ResponseEntity.ok("Ninja: " + ninjaPorIdDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o (ID): " + id + " não foi encontrado.");
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNInjaPorId(@PathVariable Long id, @RequestBody NinjaDTO atualizarNinja) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            NinjaDTO ninjaAtualizadoDTO = ninjaService.atualizarNinja(id, atualizarNinja);
            return ResponseEntity.ok("Atualizações realizada com sucesso: "
                    + ninjaAtualizadoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o (ID): " + id + " não existe nos nossos registros.");
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNInjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja do (ID): " + id + " deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja do (ID): " + id + " não foi encontrado.");
    }


}

