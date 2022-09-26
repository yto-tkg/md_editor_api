package com.md.editor.markdown;

import com.md.editor.mapper.DefaultConfig;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = DefaultConfig.class)
public interface MarkdownDxo {

    MarkdownDto entityToDto(Markdown entity);

    List<MarkdownDto> entityListToDtoList(List<Markdown> entity);

    Markdown dtoToEntity(MarkdownDto dto);

    MarkdownDto inputFormToDto(PostInputForm form);
}
