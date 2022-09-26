package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MarkdownLogicImpl implements MarkdownLogic {

    private final MarkdownRepository markdownRepository;

    private final MarkdownDxo markdownDxo;

    @Override
    public long insert(MarkdownDto dto) {
        Markdown entity = markdownDxo.dtoToEntity(dto);
        return markdownRepository.insert(entity);
    }

    @Override
    public List<MarkdownDto> getAll() {
        List<Markdown> markdownList = markdownRepository.getAll();
        return markdownDxo.entityListToDtoList(markdownList);
    }
}
