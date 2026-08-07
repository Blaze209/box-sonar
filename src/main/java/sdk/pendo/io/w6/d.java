package sdk.pendo.io.w6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import sdk.pendo.io.s7.p0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/w6/d;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String b = "";

    /* JADX INFO: renamed from: sdk.pendo.io.w6.d$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0007R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/w6/d$a;", "", "", "d", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "<set-?>", "sessionId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            d.b = "";
        }

        public final String b() {
            return p0.INSTANCE.a(16);
        }

        public final String c() {
            return d.b;
        }

        public final String d() {
            if (StringsKt.isBlank(c())) {
                d.b = b();
            }
            return c();
        }
    }
}
