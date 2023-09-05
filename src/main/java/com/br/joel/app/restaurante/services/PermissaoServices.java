package com.br.joel.app.restaurante.services;

import com.br.joel.app.restaurante.model.Grupo;
import com.br.joel.app.restaurante.model.Permissao;
import com.br.joel.app.restaurante.repository.PermissaoRepository;
import com.br.joel.app.restaurante.services.IMPL.PermissaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissaoServices  implements PermissaoImpl {

    @Autowired
    private PermissaoRepository repository;


    @Autowired
    private  GrupoServices grupoServices;
    @Override
    public List<Permissao> listar() {
        return repository.findAll();
    }

    @Override
    public Permissao buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Permissao salvar(Permissao permissao) {
        return repository.save(permissao);
    }

    @Override
    public Permissao atualizar(Long id, Permissao permissao) {
        Permissao permissao1 = buscar(id);
        if (permissao1 != null) {
            permissao1.setNome(permissao.getNome());
            permissao1.setDescricao(permissao.getDescricao());

            return repository.save(permissao1);
        }
        return null;
    }


    @Transactional
    public  void  removerPermissaoGrupo(Long idGrupo , Long idPermissao ){
        Grupo grupo =grupoServices.buscar(idGrupo);
        Permissao permissao =  buscar(idPermissao);


        grupo.getPermissoes().remove(permissao);


    }
    @Transactional
    public  void  adicionarPermissaoGrupo(Long idGrupo , Long idPermissao ){
        Grupo grupo =grupoServices.buscar(idGrupo);
        Permissao permissao =  buscar(idPermissao);


        grupo.getPermissoes().add(permissao);


    }






   @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
