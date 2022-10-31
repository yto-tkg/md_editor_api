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
     * データリストを取得する。
     *
     * @param title
     * @param sort
     * @param offset
     * @param size
     * @return
     */
    ListOutputForm getList(String title, ListOrderKey sort, OrderType order, int offset, int size);

    /**
     * IDからデータ情報を取得する
     *
     * @param id
     * @return
     */
    GetOutputForm get(long id);
}

