package androidx.media3.exoplayer.drm;

import org.apache.commons.codec.language.Soundex;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: loaded from: classes8.dex */
final class ClearKeyUtil {
    private static final String TAG = "ClearKeyUtil";

    public static byte[] adjustRequestData(byte[] bArr) {
        return bArr;
    }

    public static byte[] adjustResponseData(byte[] bArr) {
        return bArr;
    }

    private ClearKeyUtil() {
    }

    private static String base64ToBase64Url(String str) {
        return str.replace('+', Soundex.SILENT_MARKER).replace('/', SessionDataKt.UNDERSCORE);
    }

    private static String base64UrlToBase64(String str) {
        return str.replace(Soundex.SILENT_MARKER, '+').replace(SessionDataKt.UNDERSCORE, '/');
    }
}
