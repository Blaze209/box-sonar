package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public enum FilterType {
    NONE(0),
    BLACK_WHITE(1),
    PHOTO(2),
    COLOR(3),
    MONOCHROME(4);

    private final int code;

    FilterType(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
