package com.arijit.ai.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class PsnIoiDto {

    private String name;
    private String type;
    private Map<String, String> attributes;
}
