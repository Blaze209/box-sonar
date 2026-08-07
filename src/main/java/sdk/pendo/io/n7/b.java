package sdk.pendo.io.n7;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.f6.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/n7/b;", "", "Landroid/content/Context;", "context", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/u2/b;", "b", "Lsdk/pendo/io/u2/b;", "koinApp", "Lsdk/pendo/io/u2/a;", "c", "Lsdk/pendo/io/u2/a;", "()Lsdk/pendo/io/u2/a;", "koin", "", "d", "Z", "initialized", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {
    public static final b a = new b();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final sdk.pendo.io.u2.b koinApp;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final sdk.pendo.io.u2.a koin;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static volatile boolean initialized;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/u2/b;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/u2/b;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.u2.b, Unit> {
        public static final a a = new a();

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.u2.b koinApplication) {
            Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
            koinApplication.a(c.b, c.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.u2.b bVar) {
            a(bVar);
            return Unit.INSTANCE;
        }
    }

    static {
        sdk.pendo.io.u2.b bVarA = sdk.pendo.io.g3.a.a(false, a.a, 1, null);
        koinApp = bVarA;
        koin = bVarA.getKoin();
    }

    private b() {
    }

    public final sdk.pendo.io.u2.a a() {
        return koin;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            sdk.pendo.io.u2.a aVar = koin;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            sdk.pendo.io.u2.a.a(aVar, CollectionsKt.listOf(c.b(applicationContext)), false, false, 6, null);
            ((e) aVar.getScopeRegistry().getRootScope().b(Reflection.getOrCreateKotlinClass(e.class), null, null)).e();
            initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }
}
