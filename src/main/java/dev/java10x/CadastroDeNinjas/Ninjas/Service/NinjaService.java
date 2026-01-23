package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import dev.java10x.CadastroDeNinjas.Ninjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.mapper.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar o ninja - Tem que ser um metodo VOID
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Alterar/Atualizar o Ninja
    public NinjaModel alterarNinja(Long id, NinjaModel atualizarNinja) {
        if (ninjaRepository.existsById(id)) {
            atualizarNinja.setId(id);
            return ninjaRepository.save(atualizarNinja);
        }
        return null;
    }


}
