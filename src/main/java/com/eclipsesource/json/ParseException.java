package com.eclipsesource.json;

/* JADX INFO: loaded from: classes13.dex */
public class ParseException extends RuntimeException {
    private final Location location;

    ParseException(String str, Location location) {
        super(str + " at " + location);
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    @Deprecated
    public int getOffset() {
        return this.location.offset;
    }

    @Deprecated
    public int getLine() {
        return this.location.line;
    }

    @Deprecated
    public int getColumn() {
        return this.location.column;
    }
}
