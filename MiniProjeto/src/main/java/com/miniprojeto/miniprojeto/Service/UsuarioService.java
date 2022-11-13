package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    private static final int PONTOS_POR_EMBALAGEM = 1500;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarTodos(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioDto> buscarUsuarioId(Long id){
        final Optional<UsuarioModel> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            final UsuarioModel usuarioDb = opt.get();
            int totalPontos = usuarioDb.getEmbalagens().size() * PONTOS_POR_EMBALAGEM;
            final var dto =  new UsuarioDto(usuarioDb.getNomeUsuario(),usuarioDb.getCpf(),usuarioDb.getEmail(),totalPontos);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public UsuarioModel cadastraUsuario(UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alteraUsuario (UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public void deletaUsuario(Long id){

        usuarioRepository.deleteById(id);
    }
}
