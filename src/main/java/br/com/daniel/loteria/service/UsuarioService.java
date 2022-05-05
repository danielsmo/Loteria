package br.com.daniel.loteria.service;

import br.com.daniel.loteria.dto.UsuarioRequest;
import br.com.daniel.loteria.exception.UsuarioNaoEncontradoException;
import br.com.daniel.loteria.model.Usuario;
import br.com.daniel.loteria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validaUsuario(UsuarioRequest request) {


        Usuario usuario = usuarioRepository.findByCpf(request.getCpf()).orElse(new Usuario(request));

        usuarioRepository.save(usuario);
        return usuario;


    }


    public Usuario localizaUsuario(Long id) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new UsuarioNaoEncontradoException(id));

        return usuario;

    }

}
