package com.md.editor.markdown;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PutInputForm {
    @NotBlank
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String body;
}
