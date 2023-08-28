package com.br.joel.app.restaurante.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Problem {

    private  Integer  status;
    private String type;
    private String title;
    private String detail;
}
