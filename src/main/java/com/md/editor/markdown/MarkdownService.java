package com.md.editor.markdown;


public interface MarkdownService {

    /**
     * データを保存する。
     *
     * @param inputForm
     * @return id
     */
    long add(PostInputForm inputForm);
}

