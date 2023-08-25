package br.robodroolsconsumer.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Result {

    private String status = "OK";
    private List<String> messages = new ArrayList<String>();

    public Result setMessage(final String message) {
        status = "FALHA";
        messages.add(message);
        return this;
    }

}
