package org.tinylog.converters;

/* JADX INFO: loaded from: classes5.dex */
public final class NopFileConverter implements FileConverter {
    @Override // org.tinylog.converters.FileConverter
    public void close() {
    }

    @Override // org.tinylog.converters.FileConverter
    public String getBackupSuffix() {
        return null;
    }

    @Override // org.tinylog.converters.FileConverter
    public void open(String str) {
    }

    @Override // org.tinylog.converters.FileConverter
    public void shutdown() {
    }

    @Override // org.tinylog.converters.FileConverter
    public byte[] write(byte[] bArr) {
        return bArr;
    }
}
