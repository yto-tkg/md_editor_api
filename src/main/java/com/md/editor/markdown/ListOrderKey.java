package com.md.editor.markdown;

public enum ListOrderKey {
    ID("id"), TITLE("title"), BODY("body"), CREATED_AT("createdAt"), UPDATED_AT("updatedAt");

    private String columnName;

    /**
     * @param columnName
     *            対応するカラム名
     */
    ListOrderKey(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }
}
