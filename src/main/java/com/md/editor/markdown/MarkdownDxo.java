package com.md.editor.markdown;

import com.md.editor.mapper.DefaultConfig;
import org.mapstruct.Mapper;

@Mapper(config = DefaultConfig.class)
public interface MarkdownDxo {

    MarkdownDto entityToDto(Markdown entity);

    Markdown dtoToEntity(MarkdownDto dto);

    MarkdownDto inputFormToDto(PostInputForm form);
}
