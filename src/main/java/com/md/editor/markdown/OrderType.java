package com.md.editor.markdown;

public enum OrderType {
    ASC("asc"), DESC("desc");

    private String columnName;

    /**
     * @param columnName
     *            対応するカラム名
     */
    OrderType(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }
}
