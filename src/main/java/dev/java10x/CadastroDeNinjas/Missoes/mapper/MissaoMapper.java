package dev.java10x.CadastroDeNinjas.Missoes.mapper;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.dto.MissaoDTO;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissoesModel map(MissaoDTO missaoDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missaoDTO.getId());
        missoesModel.setNome(missaoDTO.getNome());
        missoesModel.setDificuldade(missaoDTO.getDificuldade());
        missoesModel.setNinjas(missaoDTO.getNinjas());

        return missoesModel;
    }

    public MissaoDTO map(MissoesModel missoesModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missoesModel.getId());
        missaoDTO.setNome(missoesModel.getNome());
        missaoDTO.setDificuldade(missoesModel.getDificuldade());
        missaoDTO.setNinjas(missoesModel.getNinjas());

        return missaoDTO;
    }

}
