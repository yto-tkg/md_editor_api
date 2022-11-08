package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PutController {

    private final MarkdownService markdownService;

    @RequestMapping(value = "/markdown/put.json", method = RequestMethod.POST)
    public void run(@RequestBody PutInputForm inputForm) {

        markdownService.update(inputForm);
    }
}
