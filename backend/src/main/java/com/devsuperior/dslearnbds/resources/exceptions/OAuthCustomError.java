package com.devsuperior.dslearnbds.resources.exceptions;

import lombok.*;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
public class OAuthCustomError {

    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
}
