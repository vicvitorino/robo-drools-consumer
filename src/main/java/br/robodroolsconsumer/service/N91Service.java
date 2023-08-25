package br.robodroolsconsumer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.robodroolsconsumer.domain.curso.Curso;
import br.robodroolsconsumer.domain.curso.CursoRepository;
import br.robodroolsconsumer.domain.projeto.Projeto;
import br.robodroolsconsumer.domain.projeto.ProjetoRepository;
import br.robodroolsconsumer.model.N91;
import br.robodroolsconsumer.model.Result;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class N91Service {

    @Autowired
    private KieContainer kContainer;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Result validar(final N91 n91) {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("projetos", getCoProjetos());
        kieSession.setGlobal("cursos", getCoCursos());
        kieSession.insert(n91);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info(n91);
        return n91.getResult();
    }

    private List<Long> getCoProjetos() {
        final List<Long> coProjetos = projetoRepository.findAll().stream()
                .map(Projeto::getCoProjeto).collect(Collectors.toList());
        // log.info(coProjetos);
        return coProjetos;
    }

    private List<Long> getCoCursos() {
        final List<Long> coCursos = cursoRepository.findAll().stream()
                .map(Curso::getCoCurso).collect(Collectors.toList());
        // log.info(coCursos);
        return coCursos;
    }

}
