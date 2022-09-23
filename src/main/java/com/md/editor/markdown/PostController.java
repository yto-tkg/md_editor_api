package com.md.editor.markdown;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final MarkdownService markdownService;

    @RequestMapping(value = "/markdown/post.json", method = RequestMethod.POST)
    public PostOutputForm run(@RequestBody PostInputForm inputForm) {

        long id = markdownService.add(inputForm);

        PostOutputForm outputForm = new PostOutputForm();
        outputForm.setId(id);
        return outputForm;
    }
}
