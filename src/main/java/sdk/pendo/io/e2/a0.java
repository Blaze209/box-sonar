package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/e2/a0;", "", "", "toString", "protocol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", SemanticAttributes.HttpFlavorValues.QUIC, "okhttp"}, k = 1, mv = {1, 8, 0})
public enum a0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(SemanticAttributes.DbSystemValues.H2),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String protocol;

    /* JADX INFO: renamed from: sdk.pendo.io.e2.a0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/e2/a0$a;", "", "", "protocol", "Lsdk/pendo/io/e2/a0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final a0 a(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            a0 a0Var = a0.HTTP_1_0;
            if (Intrinsics.areEqual(protocol, a0Var.protocol)) {
                return a0Var;
            }
            a0 a0Var2 = a0.HTTP_1_1;
            if (Intrinsics.areEqual(protocol, a0Var2.protocol)) {
                return a0Var2;
            }
            a0 a0Var3 = a0.H2_PRIOR_KNOWLEDGE;
            if (Intrinsics.areEqual(protocol, a0Var3.protocol)) {
                return a0Var3;
            }
            a0 a0Var4 = a0.HTTP_2;
            if (Intrinsics.areEqual(protocol, a0Var4.protocol)) {
                return a0Var4;
            }
            a0 a0Var5 = a0.SPDY_3;
            if (Intrinsics.areEqual(protocol, a0Var5.protocol)) {
                return a0Var5;
            }
            a0 a0Var6 = a0.QUIC;
            if (Intrinsics.areEqual(protocol, a0Var6.protocol)) {
                return a0Var6;
            }
            throw new IOException("Unexpected protocol: " + protocol);
        }
    }

    a0(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
