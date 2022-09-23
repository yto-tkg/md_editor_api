package com.md.editor.markdown;

public interface MarkdownLogic {

    /**
     * データを保存する。
     *
     * @param dto
     * @return id
     */
    long insert(MarkdownDto dto);
}

