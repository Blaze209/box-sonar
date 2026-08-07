package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0007*\u00020\u0007H\u0000\u001a0\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0000\u001a\f\u0010\u0005\u001a\u00020\u000e*\u00020\rH\u0000\u001a\f\u0010\n\u001a\u00020\u000e*\u00020\u0007H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0000\" \u0010\u0019\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u001c\u001a\u00020\u00078\u0000X\u0080D¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u0005\u0010\u001b¨\u0006\u001d"}, d2 = {"", "size", "offset", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "", "", "aOffset", "b", "bOffset", "", "", "", "Lsdk/pendo/io/s2/d$a;", "unsafeCursor", "Lsdk/pendo/io/s2/g;", ViewProps.POSITION, "sizeParam", "Lsdk/pendo/io/s2/d$a;", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "DEFAULT__new_UnsafeCursor", "I", "()I", "DEFAULT__ByteString_size", "external.sdk.pendo.io.okio"}, k = 2, mv = {1, 9, 0})
public final class b {
    private static final d.a a = new d.a();
    private static final int b = -1234567890;

    public static final int a(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final short a(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final boolean a(byte[] a2, int i, byte[] b2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (a2[i4 + i] != b2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final d.a b() {
        return a;
    }

    public static final void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final String b(int i) {
        if (i == 0) {
            return "0";
        }
        int i2 = 0;
        char[] cArr = {sdk.pendo.io.t2.b.a()[(i >> 28) & 15], sdk.pendo.io.t2.b.a()[(i >> 24) & 15], sdk.pendo.io.t2.b.a()[(i >> 20) & 15], sdk.pendo.io.t2.b.a()[(i >> 16) & 15], sdk.pendo.io.t2.b.a()[(i >> 12) & 15], sdk.pendo.io.t2.b.a()[(i >> 8) & 15], sdk.pendo.io.t2.b.a()[(i >> 4) & 15], sdk.pendo.io.t2.b.a()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return StringsKt.concatToString(cArr, i2, 8);
    }

    public static final int a() {
        return b;
    }

    public static final int a(g gVar, int i) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        return i == b ? gVar.j() : i;
    }

    public static final int a(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return i == b ? bArr.length : i;
    }

    public static final d.a a(d.a unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return unsafeCursor == a ? new d.a() : unsafeCursor;
    }

    public static final String a(byte b2) {
        return StringsKt.concatToString(new char[]{sdk.pendo.io.t2.b.a()[(b2 >> 4) & 15], sdk.pendo.io.t2.b.a()[b2 & Ascii.SI]});
    }
}
