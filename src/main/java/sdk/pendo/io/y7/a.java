package sdk.pendo.io.y7;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.f6.c;
import sdk.pendo.io.s7.u0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\u0005\u0010\n¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/y7/a;", "", "Landroid/content/Context;", "context", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/f6/c;", "Lsdk/pendo/io/f6/c;", "getEnvironmentType", "()Lsdk/pendo/io/f6/c;", "(Lsdk/pendo/io/f6/c;)V", "environmentType", "<init>", "()V", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static a c;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private c environmentType;

    /* JADX INFO: renamed from: sdk.pendo.io.y7.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/y7/a$a;", "", "Lsdk/pendo/io/y7/a;", "_INSTANCE", "Lsdk/pendo/io/y7/a;", "b", "()Lsdk/pendo/io/y7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "INSTANCE", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final a b() {
            a aVar = a.c;
            if (aVar != null) {
                return aVar;
            }
            a.c = new a();
            return a.c;
        }

        public final a a() {
            a aVarB = b();
            Intrinsics.checkNotNull(aVarB);
            return aVarB;
        }
    }

    public final void a(c cVar) {
        this.environmentType = cVar;
    }

    public final boolean a(Context context) {
        c cVar = this.environmentType;
        if (cVar == null || context == null || cVar == null || (cVar != c.DEV && cVar != c.STAGING)) {
            return false;
        }
        return u0.c(context);
    }
}
