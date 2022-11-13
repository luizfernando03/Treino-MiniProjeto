package com.miniprojeto.miniprojeto.Model;

import com.miniprojeto.miniprojeto.enumeration.Estado;
import com.miniprojeto.miniprojeto.enumeration.Marca;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "embalagens")
public class EmbalagemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado_de_cadastro", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado EstadoDeCadastro;

    @Column(length = 5, nullable = false, unique = true)
    private int numeroDeSerie;
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    public EmbalagemModel(Estado estadoDeCadastro, int numeroDeSerie, Marca marca, UsuarioModel usuarioModel) {
        this.EstadoDeCadastro = estadoDeCadastro;
        this.numeroDeSerie = numeroDeSerie;
        this.marca = marca;
        this.usuario = usuarioModel;
    }
}
