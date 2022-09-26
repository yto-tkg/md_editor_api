package com.md.editor.markdown;

import java.util.List;

public interface MarkdownLogic {

    /**
     * データを保存する。
     *
     * @param dto
     * @return id
     */
    long insert(MarkdownDto dto);

    /**
     * データを全取得する。
     *
     * @return
     */
    List<MarkdownDto> getAll();
}

