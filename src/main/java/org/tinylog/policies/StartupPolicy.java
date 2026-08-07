package org.tinylog.policies;

import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class StartupPolicy implements Policy {
    @Override // org.tinylog.policies.Policy
    public boolean continueCurrentFile(byte[] bArr) {
        return true;
    }

    @Override // org.tinylog.policies.Policy
    public boolean continueExistingFile(String str) {
        return false;
    }

    @Override // org.tinylog.policies.Policy
    public void reset() {
    }

    public StartupPolicy() {
        this(null);
    }

    public StartupPolicy(String str) {
        if (str != null) {
            InternalLogger.log(Level.WARN, "Startup policy does not support arguments");
        }
    }
}
