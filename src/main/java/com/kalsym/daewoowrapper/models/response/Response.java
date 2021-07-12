package com.kalsym.daewoowrapper.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private boolean Success;
    private boolean Error;
    private boolean Validations;
    private String Response;
}
