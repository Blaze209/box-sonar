package org.tinylog.policies;

/* JADX INFO: loaded from: classes5.dex */
public interface Policy {
    boolean continueCurrentFile(byte[] bArr);

    boolean continueExistingFile(String str);

    void reset();
}
