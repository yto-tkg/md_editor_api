package com.md.editor.markdown;


import java.util.List;

public interface MarkdownService {

    /**
     * データを保存する。
     *
     * @param inputForm
     * @return
     */
    long add(PostInputForm inputForm);

    /**
     * データを全取得する。
     *
     * @return
     */
    ListOutputForm getAll();
}

