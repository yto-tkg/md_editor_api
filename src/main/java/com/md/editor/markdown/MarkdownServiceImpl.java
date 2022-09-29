package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ListOutputForm getAll() {
        List<MarkdownDto> markdownDtoList = markdownLogic.getAll();
        ListOutputForm listOutputForm = new ListOutputForm();
        listOutputForm.setData(markdownDtoList);
        return listOutputForm;
    }
}
