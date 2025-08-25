package com.alura.GuillermoDardonChallengeForoHub.foro_hub.Validations;

import com.alura.GuillermoDardonChallengeForoHub.foro_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTituloDuplicado {

    @Autowired
    TopicoRepository repository;

    public void validar(String titulo){
        if(repository.existsByTitulo(titulo)){
          throw new ValidacionTopicoException("Este título ya fué publicado en otro tópico");
        }

    }

}
