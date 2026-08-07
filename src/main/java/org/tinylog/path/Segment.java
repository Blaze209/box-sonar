package org.tinylog.path;

import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
interface Segment {
    String createToken(String str, Timestamp timestamp);

    String getStaticText();

    boolean validateToken(String str);
}
