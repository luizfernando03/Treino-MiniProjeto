package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.EmbalagemRepository;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.dto.EmbalagemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmbalagemService {

    @Autowired
    private EmbalagemRepository embalagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<EmbalagemModel> buscaIdEmbalagem(Long id) {
        return embalagemRepository.findById(id);
    }

    public EmbalagemModel cadastrar(EmbalagemDto dto) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findById(dto.getIdUsuario());
        if(optionalUsuarioModel.isEmpty()){
            throw new IllegalArgumentException("O Id de usuário " + dto.getIdUsuario() + " informado nao foi encontrado");
        }
        EmbalagemModel embalagemModel = dto.transformarParaObjeto(optionalUsuarioModel.get());
        return embalagemRepository.save(embalagemModel);
    }
}
