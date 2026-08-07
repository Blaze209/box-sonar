package org.tinylog.policies;

import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class DynamicPolicy implements Policy {
    private static volatile boolean reset;

    @Override // org.tinylog.policies.Policy
    public boolean continueExistingFile(String str) {
        return true;
    }

    public DynamicPolicy() {
        this(null);
    }

    public DynamicPolicy(String str) {
        if (str != null) {
            InternalLogger.log(Level.WARN, "Dynamic policy does not support arguments");
        }
    }

    @Override // org.tinylog.policies.Policy
    public boolean continueCurrentFile(byte[] bArr) {
        return !reset;
    }

    @Override // org.tinylog.policies.Policy
    public void reset() {
        reset = false;
    }

    public static void setReset() {
        reset = true;
    }
}
