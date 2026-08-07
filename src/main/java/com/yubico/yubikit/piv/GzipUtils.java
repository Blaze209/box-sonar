package com.yubico.yubikit.piv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class GzipUtils {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) GzipUtils.class);

    static byte[] compress(byte[] bArr) throws IOException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Compressing {} bytes", Integer.valueOf(bArr.length));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                com.yubico.yubikit.core.internal.Logger.debug(logger2, "Compressed to {} bytes", Integer.valueOf(byteArrayOutputStream.size()));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    static byte[] decompress(byte[] bArr) throws IOException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decompressing {} bytes", Integer.valueOf(bArr.length));
        byte[] bArr2 = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    try {
                        int i = gZIPInputStream.read(bArr2, 0, 512);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr2, 0, i);
                        } else {
                            com.yubico.yubikit.core.internal.Logger.debug(logger, "Decompressed to {} bytes", Integer.valueOf(byteArrayOutputStream.size()));
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        }
                    } catch (Throwable th) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                byteArrayInputStream.close();
                throw th4;
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th6) {
                th5.addSuppressed(th6);
            }
            throw th5;
        }
    }
}
