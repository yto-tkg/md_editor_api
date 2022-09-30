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
     * @param sort
     * @param offset
     * @param size
     * @return
     */
    List<MarkdownDto> getAll(ListOrderKey sort, String order, int offset, int size);
}

