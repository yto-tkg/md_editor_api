package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListController {

    private final MarkdownService markdownService;

    @RequestMapping(value = "/markdown/list.json", method = RequestMethod.GET)
    public ListOutputForm run(@NotBlank @RequestParam(value = "sort") String sort
                              , @NotBlank @RequestParam(value = "order") String order
                              , @NotBlank @Min(0) @RequestParam(value = "offset") int offset
                              , @NotBlank @Min(0) @Max (100) @RequestParam(value = "size") int size) {


        ListOrderKey orderKey = ListOrderKey
                .valueOf(StringUtils.defaultString(sort, ListOrderKey.ID.name()));
        ListOutputForm all = markdownService.getAll(orderKey, order, offset, size);
        return all;
    }
}
