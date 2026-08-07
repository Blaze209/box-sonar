package org.tinylog.converters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
final class GzipEncoder implements Runnable {
    private static final int BUFFER_SIZE = 65536;
    static final String FILE_EXTENSION = ".gz";
    private final File sourceFile;
    private final File targetFile;

    GzipEncoder(File file) {
        this.sourceFile = file;
        File file2 = new File(file.getAbsolutePath() + FILE_EXTENSION);
        this.targetFile = file2;
        try {
            if (file2.createNewFile()) {
                return;
            }
            InternalLogger.log(Level.ERROR, "Failed to pre-create file '" + file2 + "'");
        } catch (IOException e) {
            InternalLogger.log(Level.ERROR, e, "Failed to pre-create file '" + this.targetFile + "'");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.sourceFile);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.targetFile);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream, 65536);
                    try {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i < 0) {
                                break;
                            } else {
                                gZIPOutputStream.write(bArr, 0, i);
                            }
                        }
                        gZIPOutputStream.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                        if (this.sourceFile.delete()) {
                            return;
                        }
                        InternalLogger.log(Level.WARN, "Failed to delete original log file '" + this.sourceFile + "'");
                    } catch (Throwable th) {
                        gZIPOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                fileInputStream.close();
                throw th3;
            }
        } catch (IOException e) {
            InternalLogger.log(Level.ERROR, e, "Failed to compress log file '" + this.sourceFile + "'");
        }
    }
}
