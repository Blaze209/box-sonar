package com.tokenautocomplete;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class Range {
    public final int end;
    public final int start;

    Range(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Start (%d) cannot be greater than end (%d)", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.start = i;
        this.end = i2;
    }

    public int length() {
        return this.end - this.start;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Range)) {
            Range range = (Range) obj;
            if (range.start == this.start && range.end == this.end) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(Locale.US, "[%d..%d]", Integer.valueOf(this.start), Integer.valueOf(this.end));
    }
}
