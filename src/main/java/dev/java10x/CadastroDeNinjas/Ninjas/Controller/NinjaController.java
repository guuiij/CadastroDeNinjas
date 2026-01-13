package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota!";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Essa é minha primeira mensagem nessa rota!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNInjas() {
        return "Mostrar Ninjas";
    }

    // Mostrar Ninja por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNInjasPorId() {
        return "Mostrar Ninja por ID";
    }

    // Alterar Dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNInjaPorId() {
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNInjaPorId() {
        return "Ninja deletado por ID";
    }


}

