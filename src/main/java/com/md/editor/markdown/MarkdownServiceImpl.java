package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MarkdownServiceImpl implements MarkdownService {

    private final MarkdownLogic markdownLogic;

    private final MarkdownDxo markdownDxo;

    @Override
    public long add(PostInputForm inputForm) {
        MarkdownDto dto = markdownDxo.inputFormToDto(inputForm);
        return markdownLogic.insert(dto);
    }
}
