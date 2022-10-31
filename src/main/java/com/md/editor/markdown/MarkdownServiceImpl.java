package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

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
    public ListOutputForm getList(String title, ListOrderKey sort, OrderType order, int offset, int size) {
        List<MarkdownDto> markdownDtoList = markdownLogic.getList(title, sort, order, offset, size);
        ListOutputForm listOutputForm = new ListOutputForm();
        listOutputForm.setData(markdownDtoList);
        return listOutputForm;
    }

    @Override
    public GetOutputForm get(long id) {
        MarkdownDto markdownDto = markdownLogic.get(id);
        return markdownDxo.getDtoToGetOutputForm(markdownDto);
    }
}
