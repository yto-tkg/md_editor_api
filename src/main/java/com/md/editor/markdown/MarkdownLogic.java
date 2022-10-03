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
     * データリストを取得する。
     *
     * @param title
     * @param sort
     * @param offset
     * @param size
     * @return
     */
    List<MarkdownDto> getList(String title, ListOrderKey sort, OrderType order, int offset, int size);
}

