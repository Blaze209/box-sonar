package org.tinylog.converters;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class GzipFileConverter implements FileConverter {
    private static final AtomicInteger count = new AtomicInteger();
    private final ExecutorService executor = Executors.newSingleThreadExecutor(new NamedDaemonThreadFactory("tinylog-GZipThread-" + count.getAndIncrement()));
    private volatile File file;

    @Override // org.tinylog.converters.FileConverter
    public byte[] write(byte[] bArr) {
        return bArr;
    }

    @Override // org.tinylog.converters.FileConverter
    public String getBackupSuffix() {
        return ".gz";
    }

    @Override // org.tinylog.converters.FileConverter
    public void open(String str) {
        this.file = new File(str);
    }

    @Override // org.tinylog.converters.FileConverter
    public void close() {
        this.executor.execute(new GzipEncoder(this.file));
    }

    @Override // org.tinylog.converters.FileConverter
    public void shutdown() throws InterruptedException {
        this.executor.shutdown();
        this.executor.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
