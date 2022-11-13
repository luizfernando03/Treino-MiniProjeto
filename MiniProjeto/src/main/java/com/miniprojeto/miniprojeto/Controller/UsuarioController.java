package com.miniprojeto.miniprojeto.Controller;


import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.Service.UsuarioService;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
import com.miniprojeto.miniprojeto.dto.UsuarioRespostaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
@Autowired
private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarTudo () {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioDto> buscaId(@PathVariable Long id){
        return usuarioService.buscarUsuarioId(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioRespostaDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto dto){
        UsuarioModel user = usuarioService.cadastraUsuario(dto.transformaParaObjeto());
        return new ResponseEntity<>(UsuarioRespostaDto.transformaEmDto(user), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarCadUsuario(@PathVariable Long id,@RequestBody UsuarioModel usuarioModel){
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.alteraUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
    }

}
