package sdk.pendo.io.r2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.e2.u;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0004BG\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003JP\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/r2/e;", "", "", "clientOriginated", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "toString", "", "hashCode", "other", "equals", "perMessageDeflate", "clientMaxWindowBits", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "Z", "b", "Ljava/lang/Integer;", "c", "d", "e", "f", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "g", "okhttp"}, k = 1, mv = {1, 8, 0})
public final /* data */ class e {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean perMessageDeflate;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Integer clientMaxWindowBits;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean clientNoContextTakeover;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer serverMaxWindowBits;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean serverNoContextTakeover;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean unknownValues;

    /* JADX INFO: renamed from: sdk.pendo.io.r2.e$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/r2/e$a;", "", "Lsdk/pendo/io/e2/u;", "responseHeaders", "Lsdk/pendo/io/r2/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(u responseHeaders) {
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z = false;
            Integer num = null;
            boolean z2 = false;
            Integer num2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (StringsKt.equals(responseHeaders.a(i), HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, true)) {
                    String strB = responseHeaders.b(i);
                    int i2 = 0;
                    while (i2 < strB.length()) {
                        int i3 = i2;
                        int iA = sdk.pendo.io.f2.b.a(strB, AbstractJsonLexerKt.COMMA, i3, 0, 4, null);
                        int iA2 = sdk.pendo.io.f2.b.a(strB, ';', i3, iA);
                        String strC = sdk.pendo.io.f2.b.c(strB, i3, iA2);
                        int i4 = iA2 + 1;
                        if (!StringsKt.equals(strC, "permessage-deflate", true)) {
                            i2 = i4;
                            z4 = true;
                        } else if (z) {
                            z4 = true;
                        } else {
                            z4 = true;
                            while (i4 < iA) {
                                int iA3 = sdk.pendo.io.f2.b.a(strB, ';', i4, iA);
                                int iA4 = sdk.pendo.io.f2.b.a(strB, '=', i4, iA3);
                                String strC2 = sdk.pendo.io.f2.b.c(strB, i4, iA4);
                                String strRemoveSurrounding = iA4 < iA3 ? StringsKt.removeSurrounding(sdk.pendo.io.f2.b.c(strB, iA4 + 1, iA3), (CharSequence) "\"") : null;
                                i4 = iA3 + 1;
                                if (StringsKt.equals(strC2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z4 = true;
                                    }
                                    Integer intOrNull = strRemoveSurrounding != null ? StringsKt.toIntOrNull(strRemoveSurrounding) : null;
                                    num = intOrNull;
                                    if (intOrNull == null) {
                                        z4 = true;
                                    }
                                } else if (StringsKt.equals(strC2, "client_no_context_takeover", true)) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else {
                                    if (StringsKt.equals(strC2, "server_max_window_bits", true)) {
                                        if (num2 != null) {
                                            z4 = true;
                                        }
                                        Integer intOrNull2 = strRemoveSurrounding != null ? StringsKt.toIntOrNull(strRemoveSurrounding) : null;
                                        num2 = intOrNull2;
                                        if (intOrNull2 == null) {
                                        }
                                    } else if (StringsKt.equals(strC2, "server_no_context_takeover", true)) {
                                        if (z3) {
                                            z4 = true;
                                        }
                                        if (strRemoveSurrounding != null) {
                                            z4 = true;
                                        }
                                        z3 = true;
                                    }
                                    z4 = true;
                                }
                            }
                            i2 = i4;
                            z = true;
                        }
                    }
                }
            }
            return new e(z, num, z2, num2, z3, z4);
        }
    }

    public e() {
        this(false, null, false, null, false, false, 63, null);
    }

    public final boolean a(boolean clientOriginated) {
        return clientOriginated ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return this.perMessageDeflate == eVar.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, eVar.clientMaxWindowBits) && this.clientNoContextTakeover == eVar.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, eVar.serverMaxWindowBits) && this.serverNoContextTakeover == eVar.serverNoContextTakeover && this.unknownValues == eVar.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.perMessageDeflate;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.clientNoContextTakeover;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.serverNoContextTakeover;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (iHashCode2 + r3) * 31;
        boolean z4 = this.unknownValues;
        return i3 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public e(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public /* synthetic */ e(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }
}
