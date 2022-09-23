package com.md.editor.markdown;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostInputForm {
    @NotBlank
    private String title;

    @NotBlank
    private String body;
}
