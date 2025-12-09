package com.arcade.gamon.reset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SampleObject {

    @JsonProperty("name")
    private String objectName;
    @JsonProperty("message")
    private String objectMessage;

}
