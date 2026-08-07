package io.split.android.client.utils;

import io.split.android.client.utils.logger.Logger;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public class Zlib implements CompressionUtil {
    @Override // io.split.android.client.utils.CompressionUtil
    public byte[] decompress(byte[] input) {
        if (input != null && input.length != 0) {
            try {
                Inflater inflater = new Inflater();
                inflater.setInput(input);
                byte[] bArr = new byte[10240];
                int iInflate = inflater.inflate(bArr);
                inflater.end();
                return Arrays.copyOfRange(bArr, 0, iInflate);
            } catch (DataFormatException e) {
                Logger.e("DataFormatException error: " + e.getLocalizedMessage());
            } catch (Exception e2) {
                Logger.e("Error decompressing: " + e2.getLocalizedMessage());
            }
        }
        return null;
    }
}
