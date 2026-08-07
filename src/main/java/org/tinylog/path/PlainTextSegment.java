package org.tinylog.path;

import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
final class PlainTextSegment implements Segment {
    private final String text;

    PlainTextSegment(String str) {
        this.text = str;
    }

    @Override // org.tinylog.path.Segment
    public String getStaticText() {
        return this.text;
    }

    @Override // org.tinylog.path.Segment
    public boolean validateToken(String str) {
        return this.text.equals(str);
    }

    @Override // org.tinylog.path.Segment
    public String createToken(String str, Timestamp timestamp) {
        return this.text;
    }
}
