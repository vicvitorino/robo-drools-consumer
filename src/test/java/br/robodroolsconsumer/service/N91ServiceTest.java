package br.robodroolsconsumer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.robodroolsconsumer.model.N91;
import br.robodroolsconsumer.model.Result;

@SpringBootTest
class N91ServiceTest {

    @Autowired
    private N91Service n91Service;

    @Test
    public void testParametrosObrigatorios() {
        final N91 n91 = new N91();
        final Result result = n91Service.validar(n91);

        assertNotNull(result);
        assertEquals(result.getStatus(), "FALHA");
        assertTrue(result.getMessages().contains("Parametros obrigatorios nao informados"));
    }

    @Test
    public void testProjetoInvalido() {
        final N91 n91 = new N91();
        n91.setCoProjeto(3L);
        n91.setCoCurso(1L);
        final Result result = n91Service.validar(n91);

        assertNotNull(result);
        assertEquals(result.getStatus(), "FALHA");
        assertTrue(result.getMessages().contains("Projeto invalido"));
    }

    @Test
    public void testCursoInvalido() {
        final N91 n91 = new N91();
        n91.setCoProjeto(2L);
        n91.setCoCurso(10L);
        final Result result = n91Service.validar(n91);

        assertNotNull(result);
        assertEquals(result.getStatus(), "FALHA");
        assertTrue(result.getMessages().contains("Curso invalido"));
    }

    @Test
    public void testProjetoCursoValido() {
        final N91 n91 = new N91();
        n91.setCoProjeto(1L);
        n91.setCoCurso(1L);
        n91.setNoCurso("Administracao");
        final Result result = n91Service.validar(n91);

        assertNotNull(result);
        assertEquals(result.getStatus(), "OK");
        assertTrue(result.getMessages().isEmpty());
    }

}
