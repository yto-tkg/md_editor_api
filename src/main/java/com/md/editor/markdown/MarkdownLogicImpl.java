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
    public List<MarkdownDto> getList(String title, ListOrderKey sort, OrderType order, int offset, int size) {
        List<Markdown> markdownList = markdownRepository.getList(title, sort, order, offset, size);
        return markdownDxo.entityListToDtoList(markdownList);
    }

    @Override
    public MarkdownDto get(long id) {
        Markdown markdown = markdownRepository.get(id);
        return markdownDxo.entityToDto(markdown);
    }
}
