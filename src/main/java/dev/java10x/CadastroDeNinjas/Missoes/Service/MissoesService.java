package dev.java10x.CadastroDeNinjas.Missoes.Service;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todas as missões
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Listar missão por ID
    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorIr = missoesRepository.findById(id);
        return missaoPorIr.orElse(null);
    }

    // Criar missões
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // Deletar missão por ID
    public void deletarMissaoPorID(Long id) {
        missoesRepository.deleteById(id);
    }

    // Alterar Missão por ID
    public MissoesModel alterarMissaoPorId(Long id, MissoesModel atualizarMissao) {
        if (missoesRepository.existsById(id)) {
            atualizarMissao.setId(id);
            return missoesRepository.save(atualizarMissao);
        }
        return null;
    }

}
