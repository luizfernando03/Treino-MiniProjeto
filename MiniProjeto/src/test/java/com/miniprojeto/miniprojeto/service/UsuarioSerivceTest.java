package com.miniprojeto.miniprojeto.service;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.Service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class UsuarioSerivceTest {

    @Mock
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void iniciando(){
        MockitoAnnotations.openMocks (this);
        UsuarioModel usuarioModel = new UsuarioModel (1L, "Letycia","letycia@gmail.com","11932598720");
    }

    @Test
    void exibirUsuariosTest(){
        List<UsuarioModel> buscarTodos = usuarioService.buscarTodos ();
        Assertions.assertTrue (buscarTodos.isEmpty ());
    }

    @Test
    public void testeCadastrarUsuarioFuncionando(){

        Mockito.when(usuarioRepository.existsById (Mockito.anyLong ())).thenReturn (true);
        usuarioRepository.save (usuarioModel);
        Mockito.verify (usuarioRepository, Mockito.times (1)).save (usuarioModel);

    }
}
