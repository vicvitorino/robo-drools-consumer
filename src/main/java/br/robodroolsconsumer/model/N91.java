package br.robodroolsconsumer.model;

import lombok.Data;

@Data
public class N91 {

    private Long coProjeto;
    private Long coCurso;
    private String noCurso;
    private Result result = new Result();

}
