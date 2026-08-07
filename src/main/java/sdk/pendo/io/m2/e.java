package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/m2/e;", "", "", "inbound", "", "streamId", Analytics.Data.LENGTH, "type", "flags", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(I)Ljava/lang/String;", "Lsdk/pendo/io/s2/g;", "b", "Lsdk/pendo/io/s2/g;", "CONNECTION_PREFACE", "", "c", "[Ljava/lang/String;", "FRAME_NAMES", "d", "FLAGS", "e", "BINARY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class e {
    public static final e a = new e();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final sdk.pendo.io.s2.g CONNECTION_PREFACE = sdk.pendo.io.s2.g.INSTANCE.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final String[] FLAGS = new String[64];

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final String[] BINARY;

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i] = StringsKt.replace$default(sdk.pendo.io.f2.b.a("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[9] = strArr2[1] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArr2[i2];
            int i4 = iArr[0];
            String[] strArr3 = FLAGS;
            int i5 = i4 | i3;
            strArr3[i5] = strArr3[i4] + '|' + strArr3[i3];
            strArr3[i5 | 8] = strArr3[i4] + '|' + strArr3[i3] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i6 = 0; i6 < length; i6++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i6] == null) {
                strArr4[i6] = BINARY[i6];
            }
        }
    }

    private e() {
    }

    public final String a(int type, int flags) {
        String str;
        if (flags == 0) {
            return "";
        }
        if (type != 2 && type != 3) {
            if (type == 4 || type == 6) {
                return flags == 1 ? "ACK" : BINARY[flags];
            }
            if (type != 7 && type != 8) {
                String[] strArr = FLAGS;
                if (flags < strArr.length) {
                    str = strArr[flags];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = BINARY[flags];
                }
                String str2 = str;
                if (type != 5 || (flags & 4) == 0) {
                    return (type != 0 || (flags & 32) == 0) ? str2 : StringsKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                }
                return StringsKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return BINARY[flags];
    }

    public final String a(int type) {
        String[] strArr = FRAME_NAMES;
        return type < strArr.length ? strArr[type] : sdk.pendo.io.f2.b.a("0x%02x", Integer.valueOf(type));
    }

    public final String a(boolean inbound, int streamId, int length, int type, int flags) {
        return sdk.pendo.io.f2.b.a("%s 0x%08x %5d %-13s %s", inbound ? "<<" : ">>", Integer.valueOf(streamId), Integer.valueOf(length), a(type), a(type, flags));
    }
}
