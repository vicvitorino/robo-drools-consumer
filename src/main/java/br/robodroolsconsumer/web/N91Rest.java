package br.robodroolsconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.robodroolsconsumer.model.N91;
import br.robodroolsconsumer.model.Result;
import br.robodroolsconsumer.service.N91Service;

@RestController
@RequestMapping("/n91")
public class N91Rest {

    @Autowired
    private N91Service n91service;

    @GetMapping("validar/{coProjeto}/{coCurso}")
    @ResponseBody
    public Result validar(final @PathVariable Long coProjeto, final @PathVariable Long coCurso) {
        final N91 n91 = new N91();
        n91.setCoProjeto(coProjeto);
        n91.setCoCurso(coCurso);
        return n91service.validar(n91);
    }

}
