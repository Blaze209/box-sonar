package org.tinylog.path;

import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
final class ProcessIdSegment implements Segment {
    private final String pid = Long.toString(RuntimeProvider.getProcessId());

    ProcessIdSegment() {
    }

    @Override // org.tinylog.path.Segment
    public String getStaticText() {
        return this.pid;
    }

    @Override // org.tinylog.path.Segment
    public boolean validateToken(String str) {
        return this.pid.equals(str);
    }

    @Override // org.tinylog.path.Segment
    public String createToken(String str, Timestamp timestamp) {
        return this.pid;
    }
}
