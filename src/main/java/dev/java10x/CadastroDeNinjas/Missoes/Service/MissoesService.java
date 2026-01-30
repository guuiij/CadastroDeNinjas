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
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissoesService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    // Criar missões
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissoesModel missao = missaoMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
    }

    // Listar todas as missões
    public List<MissaoDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream().map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    // Listar missão por ID
    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorIr = missoesRepository.findById(id);
        return missaoPorIr.map(missaoMapper::map).orElse(null);
    }

    // Alterar Missão por ID
    public MissaoDTO alterarMissaoPorId(Long id, MissaoDTO missaoDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missaoMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }

    // Deletar missão por ID
    public void deletarMissaoPorID(Long id) {
        missoesRepository.deleteById(id);
    }

}
