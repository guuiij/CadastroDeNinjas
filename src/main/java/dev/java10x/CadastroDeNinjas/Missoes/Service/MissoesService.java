package dev.java10x.CadastroDeNinjas.Missoes.Service;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar missão por ID

}
