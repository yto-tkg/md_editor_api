package com.md.editor.markdown;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ListOutputForm {

    private List<MarkdownDto> data;
}
