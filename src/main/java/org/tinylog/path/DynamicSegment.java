package org.tinylog.path;

import org.tinylog.policies.DynamicPolicy;
import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
public class DynamicSegment implements Segment {
    private static boolean created;
    private static final Object mutex = new Object();
    private static String text;

    DynamicSegment(String str) {
        synchronized (mutex) {
            if (text == null) {
                text = str;
            }
        }
    }

    public static String getText() {
        String str;
        synchronized (mutex) {
            str = text;
        }
        return str;
    }

    public static void setText(String str) {
        synchronized (mutex) {
            String str2 = text;
            if (str2 == null || !str2.equals(str)) {
                text = str;
                if (created) {
                    DynamicPolicy.setReset();
                }
            }
        }
    }

    @Override // org.tinylog.path.Segment
    public String getStaticText() {
        String str;
        synchronized (mutex) {
            created = true;
            str = text;
        }
        return str;
    }

    @Override // org.tinylog.path.Segment
    public boolean validateToken(String str) {
        boolean z;
        synchronized (mutex) {
            String str2 = text;
            z = str2 != null && str2.equals(str);
        }
        return z;
    }

    @Override // org.tinylog.path.Segment
    public String createToken(String str, Timestamp timestamp) {
        return getStaticText();
    }
}
