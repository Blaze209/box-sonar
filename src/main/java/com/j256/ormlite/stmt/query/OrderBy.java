package com.j256.ormlite.stmt.query;

/* JADX INFO: loaded from: classes14.dex */
public class OrderBy {
    private final boolean ascending;
    private final String columnName;

    public OrderBy(String str, boolean z) {
        this.columnName = str;
        this.ascending = z;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public boolean isAscending() {
        return this.ascending;
    }
}
