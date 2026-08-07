package org.apache.hc.core5.http;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: loaded from: classes5.dex */
public class ParseException extends ProtocolException {
    private static final long serialVersionUID = -7288819855864183578L;
    private final int errorOffset;

    public ParseException() {
        this.errorOffset = -1;
    }

    public ParseException(String str) {
        super(str);
        this.errorOffset = -1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ParseException(String str, CharSequence charSequence, int i, int i2, int i3) {
        String str2 = "";
        StringBuilder sbAppend = new StringBuilder().append(str).append(i3 >= 0 ? "; error at offset " + i3 : "");
        if (charSequence != null && i2 < 1024) {
            str2 = ": <" + ((Object) charSequence.subSequence(i, i2 + i)) + SimpleComparison.GREATER_THAN_OPERATION;
        }
        super(sbAppend.append(str2).toString());
        this.errorOffset = i3;
    }

    public ParseException(String str, CharSequence charSequence, int i, int i2) {
        this(str, charSequence, i, i2, -1);
    }

    public int getErrorOffset() {
        return this.errorOffset;
    }
}
