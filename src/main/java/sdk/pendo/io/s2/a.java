package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0000\" \u0010\t\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\" \u0010\r\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"", "map", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64", "b", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "BASE64_URL_SAFE", "external.sdk.pendo.io.okio"}, k = 2, mv = {1, 9, 0})
public final class a {
    private static final byte[] a;
    private static final byte[] b;

    static {
        g.a aVar = g.d;
        a = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").b();
        b = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").b();
    }

    public static final String a(byte[] bArr, byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b2 = bArr[i];
            int i3 = i + 2;
            byte b3 = bArr[i + 1];
            i += 3;
            byte b4 = bArr[i3];
            bArr2[i2] = map[(b2 & 255) >> 2];
            bArr2[i2 + 1] = map[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr2[i2 + 2] = map[((b3 & Ascii.SI) << 2) | ((b4 & 255) >> 6)];
            i2 += 4;
            bArr2[i4] = map[b4 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            bArr2[i2] = map[(b5 & 255) >> 2];
            bArr2[i2 + 1] = map[(b5 & 3) << 4];
            bArr2[i2 + 2] = 61;
            bArr2[i2 + 3] = 61;
        } else if (length2 == 2) {
            int i5 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i5];
            bArr2[i2] = map[(b6 & 255) >> 2];
            bArr2[i2 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr2[i2 + 2] = map[(b7 & Ascii.SI) << 2];
            bArr2[i2 + 3] = 61;
        }
        return d0.a(bArr2);
    }

    public static /* synthetic */ String a(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = a;
        }
        return a(bArr, bArr2);
    }
}
