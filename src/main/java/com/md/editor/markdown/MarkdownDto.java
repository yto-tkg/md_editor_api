package com.md.editor.markdown;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class MarkdownDto {

    private long id;
    private String title;
    private String body;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
