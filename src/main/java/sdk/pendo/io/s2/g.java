package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0005B\u0011\b\u0000\u0012\u0006\u0010'\u001a\u00020\u0014¢\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\u0007\u001a\u00020\u0000J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0087\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010\u0016\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0005\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0010¢\u0006\u0004\b\u0005\u0010\u001dJ(\u0010\u0005\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J(\u0010\u0005\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0000J\u0013\u0010#\u001a\u00020 2\b\u0010\u001e\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010$\u001a\u00020\fH\u0016J\u0011\u0010\u0005\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002J\b\u0010%\u001a\u00020\u0003H\u0016R\u001a\u0010'\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b\u000f\u0010\u0017R\"\u0010$\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\u0013\"\u0004\b)\u0010*R$\u0010/\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010+\u001a\u0004\b,\u0010-\"\u0004\b\u000f\u0010.R\u0011\u00101\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b0\u0010\u0013¨\u00064"}, d2 = {"Lsdk/pendo/io/s2/g;", "Ljava/io/Serializable;", "", "", CmcdData.OBJECT_TYPE_MANIFEST, CmcdData.OBJECT_TYPE_AUDIO_ONLY, CmcdData.STREAMING_FORMAT_HLS, "i", "algorithm", "(Ljava/lang/String;)Lsdk/pendo/io/s2/g;", "f", "k", "", "pos", "", "b", "(I)B", FirebaseAnalytics.Param.INDEX, "d", "()I", "", CmcdData.STREAM_TYPE_LIVE, "g", "()[B", "Lsdk/pendo/io/s2/d;", "buffer", "offset", "byteCount", "", "(Lsdk/pendo/io/s2/d;II)V", "other", "otherOffset", "", "prefix", "", "equals", "hashCode", "toString", "[B", "data", "I", "c", "(I)V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "utf8", "j", "size", "<init>", "([B)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public class g implements Serializable, Comparable<g> {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final g e = new g(new byte[0]);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final byte[] data;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private transient int hashCode;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private transient String utf8;

    /* JADX INFO: renamed from: sdk.pendo.io.s2.g$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007J'\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\f\u0010\f\u001a\u00020\u0005*\u00020\u000bH\u0007J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u000fJ\f\u0010\u0006\u001a\u00020\u0005*\u00020\u000bH\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/s2/g$a;", "", "", "", "data", "Lsdk/pendo/io/s2/g;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "offset", "byteCount", "([BII)Lsdk/pendo/io/s2/g;", "", "b", "Ljava/nio/charset/Charset;", "charset", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lsdk/pendo/io/s2/g;", "EMPTY", "Lsdk/pendo/io/s2/g;", "", "serialVersionUID", "J", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final g a(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((sdk.pendo.io.t2.b.b(str.charAt(i2)) << 4) + sdk.pendo.io.t2.b.b(str.charAt(i2 + 1)));
            }
            return new g(bArr);
        }

        @JvmStatic
        public final g b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            g gVar = new g(d0.a(str));
            gVar.b(str);
            return gVar;
        }

        @JvmStatic
        public final g a(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new g(bytes);
        }

        @JvmStatic
        public final g a(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
            return new g(bArrCopyOf);
        }

        @JvmStatic
        public final g a(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            int iA = b.a(bArr, i2);
            b.a(bArr.length, i, iA);
            return new g(ArraysKt.copyOfRange(bArr, i, iA + i));
        }

        public static /* synthetic */ g a(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = b.a();
            }
            return companion.a(bArr, i, i2);
        }
    }

    public g(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public String a() {
        return a.a(getData(), null, 1, null);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int d() {
        return getData().length;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof g) {
            g gVar = (g) other;
            if (gVar.j() == getData().length && gVar.a(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        char[] cArr = new char[getData().length * 2];
        int i = 0;
        for (byte b : getData()) {
            int i2 = i + 1;
            cArr[i] = sdk.pendo.io.t2.b.a()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = sdk.pendo.io.t2.b.a()[b & Ascii.SI];
        }
        return StringsKt.concatToString(cArr);
    }

    public byte[] g() {
        return getData();
    }

    public final g h() {
        return a("SHA-1");
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        c(iHashCode);
        return iHashCode;
    }

    public final g i() {
        return a("SHA-256");
    }

    public final int j() {
        return d();
    }

    public g k() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 65 && b <= 90) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] l() {
        byte[] data = getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String m() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String strA = d0.a(g());
        b(strA);
        return strA;
    }

    public String toString() {
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        StringBuilder sbAppend3;
        if (getData().length == 0) {
            return "[size=0]";
        }
        int iB = sdk.pendo.io.t2.b.b(getData(), 64);
        if (iB != -1) {
            String strM = m();
            String strSubstring = strM.substring(0, iB);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
            if (iB < strM.length()) {
                sbAppend2 = new StringBuilder("[size=").append(getData().length).append(" text=").append(strReplace$default);
                sbAppend3 = sbAppend2.append("…]");
            } else {
                sbAppend = new StringBuilder("[text=").append(strReplace$default);
                sbAppend3 = sbAppend.append(AbstractJsonLexerKt.END_LIST);
            }
        } else if (getData().length <= 64) {
            sbAppend = new StringBuilder("[hex=").append(f());
            sbAppend3 = sbAppend.append(AbstractJsonLexerKt.END_LIST);
        } else {
            StringBuilder sbAppend4 = new StringBuilder("[size=").append(getData().length).append(" hex=");
            g gVar = this;
            int iA = b.a(gVar, 64);
            if (iA > gVar.getData().length) {
                throw new IllegalArgumentException(("endIndex > length(" + gVar.getData().length + ')').toString());
            }
            if (iA < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            if (iA != gVar.getData().length) {
                gVar = new g(ArraysKt.copyOfRange(gVar.getData(), 0, iA));
            }
            sbAppend2 = sbAppend4.append(gVar.f());
            sbAppend3 = sbAppend2.append("…]");
        }
        return sbAppend3.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iJ = j();
        int iJ2 = other.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i = 0; i < iMin; i++) {
            int iA = a(i) & 255;
            int iA2 = other.a(i) & 255;
            if (iA != iA2) {
                return iA < iA2 ? -1 : 1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        return iJ < iJ2 ? -1 : 1;
    }

    public byte b(int pos) {
        return getData()[pos];
    }

    public final void c(int i) {
        this.hashCode = i;
    }

    public g a(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, j());
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNull(bArrDigest);
        return new g(bArrDigest);
    }

    public final void b(String str) {
        this.utf8 = str;
    }

    public final byte a(int index) {
        return b(index);
    }

    public final boolean b(g prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return a(0, prefix, 0, prefix.j());
    }

    @JvmStatic
    public static final g a(byte... bArr) {
        return INSTANCE.a(bArr);
    }

    public boolean a(int offset, g other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.a(otherOffset, getData(), offset, byteCount);
    }

    public boolean a(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && b.a(getData(), offset, other, otherOffset, byteCount);
    }

    public void a(d buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        sdk.pendo.io.t2.b.a(this, buffer, offset, byteCount);
    }
}
