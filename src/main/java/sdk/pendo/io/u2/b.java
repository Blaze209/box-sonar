package sdk.pendo.io.u2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a3.c;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\t\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/u2/b;", "", "", "Lsdk/pendo/io/b3/a;", "modules", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "([Lsdk/pendo/io/b3/a;)Lsdk/pendo/io/u2/b;", "b", "Lsdk/pendo/io/u2/a;", "Lsdk/pendo/io/u2/a;", "()Lsdk/pendo/io/u2/a;", "koin", "", "Z", "allowOverride", "<init>", "()V", "c", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a koin;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private boolean allowOverride;

    /* JADX INFO: renamed from: sdk.pendo.io.u2.b$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/u2/b$a;", "", "Lsdk/pendo/io/u2/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "koin-core"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return new b(null);
        }
    }

    private b() {
        this.koin = new a();
        this.allowOverride = true;
    }

    public final void a() {
        this.koin.a();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final a getKoin() {
        return this.koin;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void a(List<sdk.pendo.io.b3.a> modules) {
        this.koin.a(modules, this.allowOverride, false);
    }

    public final b b(List<sdk.pendo.io.b3.a> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        c logger = this.koin.getLogger();
        sdk.pendo.io.a3.b bVar = sdk.pendo.io.a3.b.INFO;
        if (!logger.a(bVar)) {
            a(modules);
            return this;
        }
        sdk.pendo.io.i3.a aVar = sdk.pendo.io.i3.a.a;
        long jA = aVar.a();
        a(modules);
        this.koin.getLogger().a(bVar, "Started " + this.koin.getInstanceRegistry().b() + " definitions in " + ((Number) new Pair(Unit.INSTANCE, Double.valueOf((aVar.a() - jA) / 1000000.0d)).getSecond()).doubleValue() + " ms");
        return this;
    }

    public final b a(sdk.pendo.io.b3.a... modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        return b(ArraysKt.toList(modules));
    }
}
