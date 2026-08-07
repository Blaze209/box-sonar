package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Gzip implements CompressionUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.split.android.client.utils.Gzip] */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    @Override // io.split.android.client.utils.CompressionUtil
    public byte[] decompress(byte[] input) throws Throwable {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        if (input == 0 || input.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i = gZIPInputStream.read(bArr);
                        if (i >= 0) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            close(byteArrayOutputStream);
                            close(gZIPInputStream);
                            close(byteArrayInputStream);
                            return byteArray;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    Logger.e("Gzip format error: " + e.getLocalizedMessage());
                    close(byteArrayOutputStream);
                    close(gZIPInputStream);
                    close(byteArrayInputStream);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    Logger.e("Error decompressing gzip: " + e.getLocalizedMessage());
                    close(byteArrayOutputStream);
                    close(gZIPInputStream);
                    close(byteArrayInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                close(byteArrayOutputStream);
                close(input);
                close(byteArrayInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            gZIPInputStream = null;
        } catch (Exception e4) {
            e = e4;
            gZIPInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            input = 0;
            close(byteArrayOutputStream);
            close(input);
            close(byteArrayInputStream);
            throw th;
        }
    }

    void close(Closeable component) {
        try {
            component.close();
        } catch (Exception e) {
            Logger.e("Gzip error closing component: " + e.getLocalizedMessage());
        }
    }
}
