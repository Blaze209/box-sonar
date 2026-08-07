package io.split.android.client.utils;

import android.util.Base64;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class Base64Util {
    public static String decode(String string) {
        byte[] bArrBytesDecode = bytesDecode(string);
        if (bArrBytesDecode != null) {
            return StringHelper.stringFromBytes(bArrBytesDecode);
        }
        return null;
    }

    public static byte[] bytesDecode(String string) {
        try {
            return Base64.decode(string, 0);
        } catch (IllegalArgumentException e) {
            Logger.e("Received bytes didn't correspond to a valid Base64 encoded string." + e.getLocalizedMessage());
            return null;
        } catch (Exception e2) {
            Logger.e("An unknown error has occurred " + e2.getLocalizedMessage());
            return null;
        }
    }

    public static String encode(String string) {
        try {
            return StringHelper.stringFromBytes(Base64.encode(string.getBytes(StringHelper.defaultCharset()), 0));
        } catch (IllegalArgumentException e) {
            Logger.e("Received bytes didn't correspond to a valid Base64 encoded string." + e.getLocalizedMessage());
            return null;
        } catch (Exception e2) {
            Logger.e("An unknown error has occurred " + e2.getLocalizedMessage());
            return null;
        }
    }

    public static String encode(byte[] bytes) {
        return Base64.encodeToString(bytes, 0);
    }
}
