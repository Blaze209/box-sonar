package org.tinylog.converters;

/* JADX INFO: loaded from: classes5.dex */
public interface FileConverter {
    void close();

    String getBackupSuffix();

    void open(String str);

    void shutdown() throws InterruptedException;

    byte[] write(byte[] bArr);
}
