package dev.java10x.CadastroDeNinjas.Missoes.Service;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import dev.java10x.CadastroDeNinjas.Missoes.dto.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Missoes.mapper.MissaoMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissoesService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
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
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissoesModel missao = missaoMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
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
