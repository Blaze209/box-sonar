package com.microsoft.identity.common.internal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes14.dex */
public class GzipUtil {
    public static byte[] compressString(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bytes, 0, bytes.length);
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String decompressBytesToString(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[256];
        while (true) {
            int i = gZIPInputStream.read(bArr2);
            if (i >= 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            } else {
                gZIPInputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                return new String(byteArray, 0, byteArray.length, "UTF-8");
            }
        }
    }
}
