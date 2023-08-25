package br.robodroolsconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.robodroolsconsumer.model.N91;

@Service
public class N91Consumer {

    @Autowired
    private N91Service n91service;

    @JmsListener(destination = "robo-drools::n91")
    public void consumir(final String message) throws Exception {
        final N91 n91 = new ObjectMapper().readValue(message, N91.class);
        n91service.validar(n91).toString();
    }
    
}
