package org.tinylog.policies;

import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class SizePolicy implements Policy {
    private static final long GB = 1073741824;
    private static final long KB = 1024;
    private static final long MB = 1048576;
    private long count;
    private final long maximum;

    public SizePolicy() {
        this(null);
    }

    public SizePolicy(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("No maximum size defined for size policy");
        }
        try {
            long j = parse(str.toLowerCase(Locale.ROOT));
            this.maximum = j;
            if (j <= 0) {
                throw new IllegalArgumentException("Invalid size \"" + str + "\" for size policy");
            }
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("Invalid size \"" + str + "\" for size policy");
        }
    }

    @Override // org.tinylog.policies.Policy
    public boolean continueExistingFile(String str) {
        long length = new File(str).length();
        this.count = length;
        return length <= this.maximum;
    }

    @Override // org.tinylog.policies.Policy
    public boolean continueCurrentFile(byte[] bArr) {
        long length = this.count + ((long) bArr.length);
        this.count = length;
        return length <= this.maximum;
    }

    @Override // org.tinylog.policies.Policy
    public void reset() {
        this.count = 0L;
    }

    private static long parse(String str) throws NumberFormatException {
        if (str.endsWith("gb")) {
            return Long.parseLong(str.substring(0, str.length() - "gb".length()).trim()) * 1073741824;
        }
        if (str.endsWith("mb")) {
            return Long.parseLong(str.substring(0, str.length() - "mb".length()).trim()) * 1048576;
        }
        if (str.endsWith("kb")) {
            return Long.parseLong(str.substring(0, str.length() - "kb".length()).trim()) * 1024;
        }
        if (str.endsWith("bytes")) {
            return Long.parseLong(str.substring(0, str.length() - "bytes".length()).trim());
        }
        return Long.parseLong(str.trim());
    }
}
