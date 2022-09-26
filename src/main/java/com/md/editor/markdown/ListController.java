package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListController {

    private final MarkdownService markdownService;

    @RequestMapping(value = "/markdown/list.json", method = RequestMethod.GET)
    public ListOutputForm run() {

        return markdownService.getAll();
    }
}
