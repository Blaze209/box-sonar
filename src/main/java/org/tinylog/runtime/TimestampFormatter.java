package org.tinylog.runtime;

/* JADX INFO: loaded from: classes5.dex */
public interface TimestampFormatter {
    String format(Timestamp timestamp);

    boolean isValid(String str);
}
