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
     * @param sort
     * @param offset
     * @param size
     * @return
     */
    ListOutputForm getAll(ListOrderKey sort, String order, int offset, int size);
}

