package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lsdk/pendo/io/e2/i;", "", "", "toString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "javaName", "<init>", "(Ljava/lang/String;)V", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class i {
    public static final i A;
    public static final i A0;
    public static final i B;
    public static final i B0;
    public static final i C;
    public static final i C0;
    public static final i D;
    public static final i D0;
    public static final i E;
    public static final i E0;
    public static final i F;
    public static final i F0;
    public static final i G;
    public static final i G0;
    public static final i H;
    public static final i H0;
    public static final i I;
    public static final i I0;
    public static final i J;
    public static final i J0;
    public static final i K;
    public static final i K0;
    public static final i L;
    public static final i L0;
    public static final i M;
    public static final i M0;
    public static final i N;
    public static final i N0;
    public static final i O;
    public static final i O0;
    public static final i P;
    public static final i P0;
    public static final i Q;
    public static final i Q0;
    public static final i R;
    public static final i R0;
    public static final i S;
    public static final i S0;
    public static final i T;
    public static final i T0;
    public static final i U;
    public static final i U0;
    public static final i V;
    public static final i V0;
    public static final i W;
    public static final i W0;
    public static final i X;
    public static final i X0;
    public static final i Y;
    public static final i Y0;
    public static final i Z;
    public static final i Z0;
    public static final i a0;
    public static final i a1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final i b0;
    public static final i b1;
    private static final Comparator<String> c;
    public static final i c0;
    public static final i c1;
    private static final Map<String, i> d;
    public static final i d0;
    public static final i d1;
    public static final i e;
    public static final i e0;
    public static final i e1;
    public static final i f;
    public static final i f0;
    public static final i f1;
    public static final i g;
    public static final i g0;
    public static final i g1;
    public static final i h;
    public static final i h0;
    public static final i h1;
    public static final i i;
    public static final i i0;
    public static final i i1;
    public static final i j;
    public static final i j0;
    public static final i j1;
    public static final i k;
    public static final i k0;
    public static final i k1;
    public static final i l;
    public static final i l0;
    public static final i l1;
    public static final i m;
    public static final i m0;
    public static final i m1;
    public static final i n;
    public static final i n0;
    public static final i n1;
    public static final i o;
    public static final i o0;
    public static final i o1;
    public static final i p;
    public static final i p0;
    public static final i p1;
    public static final i q;
    public static final i q0;
    public static final i q1;
    public static final i r;
    public static final i r0;
    public static final i r1;
    public static final i s;
    public static final i s0;
    public static final i s1;
    public static final i t;
    public static final i t0;
    public static final i u;
    public static final i u0;
    public static final i v;
    public static final i v0;
    public static final i w;
    public static final i w0;
    public static final i x;
    public static final i x0;
    public static final i y;
    public static final i y0;
    public static final i z;
    public static final i z0;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String javaName;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0018\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"sdk/pendo/io/e2/i$a", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String a, String b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            int iMin = Math.min(a.length(), b.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = a.charAt(i);
                char cCharAt2 = b.charAt(i);
                if (cCharAt != cCharAt2) {
                    return Intrinsics.compare((int) cCharAt, (int) cCharAt2) < 0 ? -1 : 1;
                }
            }
            int length = a.length();
            int length2 = b.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.e2.i$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b}\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0014\u0010 \u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0012R\u0014\u0010!\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0012R\u0014\u0010\"\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u0014\u0010&\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0014\u0010'\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0012R\u0014\u0010(\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0014\u0010)\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0012R\u0014\u0010+\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0012R\u0014\u0010,\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0012R\u0014\u0010-\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0012R\u0014\u0010.\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0012R\u0014\u0010/\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0012R\u0014\u00100\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0012R\u0014\u00101\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0012R\u0014\u00102\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0012R\u0014\u00103\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0012R\u0014\u00104\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0012R\u0014\u00105\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0012R\u0014\u00106\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0012R\u0014\u00107\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0012R\u0014\u00108\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0012R\u0014\u00109\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0012R\u0014\u0010:\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0012R\u0014\u0010;\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0012R\u0014\u0010<\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0012R\u0014\u0010=\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b=\u0010\u0012R\u0014\u0010>\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0012R\u0014\u0010?\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0012R\u0014\u0010@\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0012R\u0014\u0010A\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0012R\u0014\u0010B\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u0010\u0012R\u0014\u0010C\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010\u0012R\u0014\u0010D\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010\u0012R\u0014\u0010E\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0012R\u0014\u0010F\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0012R\u0014\u0010H\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010\u0012R\u0014\u0010I\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0012R\u0014\u0010J\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0012R\u0014\u0010K\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0012R\u0014\u0010L\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010\u0012R\u0014\u0010M\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010\u0012R\u0014\u0010N\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010\u0012R\u0014\u0010O\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0012R\u0014\u0010P\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0012R\u0014\u0010Q\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u0012R\u0014\u0010R\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010\u0012R\u0014\u0010S\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010\u0012R\u0014\u0010T\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0012R\u0014\u0010U\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0012R\u0014\u0010V\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010\u0012R\u0014\u0010W\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010\u0012R\u0014\u0010X\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010\u0012R\u0014\u0010Y\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010\u0012R\u0014\u0010Z\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010\u0012R\u0014\u0010[\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010\u0012R\u0014\u0010\\\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010\u0012R\u0014\u0010]\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010\u0012R\u0014\u0010^\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u0010\u0012R\u0014\u0010_\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010\u0012R\u0014\u0010`\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010\u0012R\u0014\u0010a\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010\u0012R\u0014\u0010b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010\u0012R\u0014\u0010c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010\u0012R\u0014\u0010d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010\u0012R\u0014\u0010e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010\u0012R\u0014\u0010f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010\u0012R\u0014\u0010g\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010\u0012R\u0014\u0010h\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010\u0012R\u0014\u0010i\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010\u0012R\u0014\u0010j\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010\u0012R\u0014\u0010k\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010\u0012R\u0014\u0010l\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010\u0012R\u0014\u0010m\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010\u0012R\u0014\u0010n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010\u0012R\u0014\u0010o\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u0010\u0012R\u0014\u0010p\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010\u0012R\u0014\u0010q\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010\u0012R\u0014\u0010r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010\u0012R\u0014\u0010s\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010\u0012R\u0014\u0010t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bt\u0010\u0012R\u0014\u0010u\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bu\u0010\u0012R\u0014\u0010v\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010\u0012R\u0014\u0010w\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010\u0012R\u0014\u0010x\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010\u0012R\u0014\u0010y\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\by\u0010\u0012R\u0014\u0010z\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bz\u0010\u0012R\u0014\u0010{\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b{\u0010\u0012R\u0014\u0010|\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b|\u0010\u0012R\u0014\u0010}\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b}\u0010\u0012R\u0014\u0010~\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b~\u0010\u0012R\u0014\u0010\u007f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010\u0012R\u0016\u0010\u0080\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u0012R\u0016\u0010\u0081\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u0012R\u0016\u0010\u0082\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u0012R\u0016\u0010\u0083\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\u0012R\u0016\u0010\u0084\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0012R\u0016\u0010\u0085\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u0012R\u0016\u0010\u0086\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u0012R\u0016\u0010\u0087\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\u0012R\u0016\u0010\u0088\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\u0012¨\u0006\u008b\u0001"}, d2 = {"Lsdk/pendo/io/e2/i$b;", "", "", "javaName", "b", "", "value", "Lsdk/pendo/io/e2/i;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "()Ljava/util/Comparator;", "", "INSTANCES", "Ljava/util/Map;", "TLS_AES_128_CCM_8_SHA256", "Lsdk/pendo/io/e2/i;", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(String javaName) {
            StringBuilder sbAppend;
            if (StringsKt.startsWith$default(javaName, "TLS_", false, 2, (Object) null)) {
                StringBuilder sb = new StringBuilder("SSL_");
                String strSubstring = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                sbAppend = sb.append(strSubstring);
            } else {
                if (!StringsKt.startsWith$default(javaName, "SSL_", false, 2, (Object) null)) {
                    return javaName;
                }
                StringBuilder sb2 = new StringBuilder("TLS_");
                String strSubstring2 = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sbAppend = sb2.append(strSubstring2);
            }
            return sbAppend.toString();
        }

        @JvmStatic
        public final synchronized i a(String javaName) {
            i iVar;
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            iVar = (i) i.d.get(javaName);
            if (iVar == null) {
                iVar = (i) i.d.get(b(javaName));
                if (iVar == null) {
                    iVar = new i(javaName, null);
                }
                i.d.put(javaName, iVar);
            }
            return iVar;
        }

        public final Comparator<String> a() {
            return i.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final i a(String javaName, int value) {
            i iVar = new i(javaName, null);
            i.d.put(javaName, iVar);
            return iVar;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        c = new a();
        d = new LinkedHashMap();
        e = companion.a("SSL_RSA_WITH_NULL_MD5", 1);
        f = companion.a("SSL_RSA_WITH_NULL_SHA", 2);
        g = companion.a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        h = companion.a("SSL_RSA_WITH_RC4_128_MD5", 4);
        i = companion.a("SSL_RSA_WITH_RC4_128_SHA", 5);
        j = companion.a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        k = companion.a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        l = companion.a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m = companion.a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        n = companion.a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        o = companion.a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        p = companion.a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        q = companion.a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        r = companion.a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        s = companion.a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        t = companion.a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        u = companion.a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        v = companion.a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        w = companion.a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        x = companion.a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        y = companion.a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        z = companion.a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        A = companion.a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        B = companion.a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C = companion.a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        D = companion.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        E = companion.a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        F = companion.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        G = companion.a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        H = companion.a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I = companion.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        J = companion.a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        K = companion.a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        L = companion.a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        M = companion.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        N = companion.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        O = companion.a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        P = companion.a("TLS_RSA_WITH_NULL_SHA256", 59);
        Q = companion.a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        R = companion.a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        S = companion.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        T = companion.a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        U = companion.a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        V = companion.a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        W = companion.a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        X = companion.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        Y = companion.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Z = companion.a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        a0 = companion.a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b0 = companion.a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Token.TARGET);
        c0 = companion.a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        d0 = companion.a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        e0 = companion.a("TLS_PSK_WITH_RC4_128_SHA", 138);
        f0 = companion.a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        g0 = companion.a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        h0 = companion.a("TLS_PSK_WITH_AES_256_CBC_SHA", Token.SETELEM_OP);
        i0 = companion.a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        j0 = companion.a("TLS_RSA_WITH_AES_128_GCM_SHA256", Token.SETCONST);
        k0 = companion.a("TLS_RSA_WITH_AES_256_GCM_SHA384", Token.SETCONSTVAR);
        l0 = companion.a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Token.ARRAYCOMP);
        m0 = companion.a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Token.LETEXPR);
        n0 = companion.a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Token.COMMENT);
        o0 = companion.a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Token.GENEXPR);
        p0 = companion.a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Token.YIELD_STAR);
        q0 = companion.a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", Token.LAST_TOKEN);
        r0 = companion.a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        s0 = companion.a("TLS_FALLBACK_SCSV", 22016);
        t0 = companion.a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        u0 = companion.a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        v0 = companion.a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        w0 = companion.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        x0 = companion.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        y0 = companion.a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        z0 = companion.a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        A0 = companion.a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        B0 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C0 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        D0 = companion.a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        E0 = companion.a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        F0 = companion.a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        G0 = companion.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        H0 = companion.a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I0 = companion.a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        J0 = companion.a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        K0 = companion.a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        L0 = companion.a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        M0 = companion.a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        N0 = companion.a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        O0 = companion.a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        P0 = companion.a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        Q0 = companion.a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        R0 = companion.a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        S0 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        T0 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        U0 = companion.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        V0 = companion.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        W0 = companion.a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        X0 = companion.a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        Y0 = companion.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Z0 = companion.a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        a1 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        b1 = companion.a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c1 = companion.a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        d1 = companion.a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        e1 = companion.a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f1 = companion.a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        g1 = companion.a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        h1 = companion.a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        i1 = companion.a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        j1 = companion.a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        k1 = companion.a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        l1 = companion.a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        m1 = companion.a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        n1 = companion.a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        o1 = companion.a("TLS_AES_128_GCM_SHA256", 4865);
        p1 = companion.a("TLS_AES_256_GCM_SHA384", 4866);
        q1 = companion.a("TLS_CHACHA20_POLY1305_SHA256", 4867);
        r1 = companion.a("TLS_AES_128_CCM_SHA256", 4868);
        s1 = companion.a("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private i(String str) {
        this.javaName = str;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getJavaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }

    public /* synthetic */ i(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
