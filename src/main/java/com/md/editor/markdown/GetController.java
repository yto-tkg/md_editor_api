package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
public class GetController {

    private final MarkdownService markdownService;

    @RequestMapping(value = "/markdown/get.json", method = RequestMethod.GET)
    public GetOutputForm run(@RequestParam(value = "id", required = true) long id) {
        return markdownService.get(id);
    }
}
