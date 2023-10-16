package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.exceptions.EntidadeNaoEncontradaException;
import com.br.joel.app.restaurante.model.Usuario;
import com.br.joel.app.restaurante.model.input.UsuarioSenhaInput;
import com.br.joel.app.restaurante.repository.UsuarioRepository;
import com.br.joel.app.restaurante.services.IMPL.UsuarioImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices implements UsuarioImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();

    }
    @Override
    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario salvar(Usuario usuario) {

        Optional<Usuario> usuario1 = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuario1.isPresent() && !usuario1.get().equals(usuario)) {
            throw new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST, "Email ja cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuario1 = buscar(id);

        if(usuario1 == null) {
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST, "Id nao encontrado");
        }

        BeanUtils.copyProperties(usuario, usuario1, "id", "dataCadastro", "senha");
        usuarioRepository.save(usuario1);
        return usuario1;
    }


    public Usuario  atualizarSenha(Long id, UsuarioSenhaInput senha) throws Exception {
        Usuario usuario = buscar(id);

        if(usuario == null) {
            throw  new EntidadeNaoEncontradaException(HttpStatus.BAD_REQUEST, "Id nao encontrado");
        }
        boolean senhaAtual =   usuario.getSenha().equals(senha.getSenha());

            if(senhaAtual == false ) {
                throw new Exception("Senha atual incorreta");
            }else {
                usuario.setSenha(senha.getNovaSenha());
                usuarioRepository.save(usuario);
            }


        return  usuario;

    }

    @Override
    public void remover(Long id) {
        usuarioRepository.deleteById(id);
    }
}
