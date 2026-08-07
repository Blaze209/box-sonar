package sdk.pendo.io.z2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/z2/b;", "", "Lsdk/pendo/io/a3/c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/a3/c;", "()Lsdk/pendo/io/a3/c;", "logger", "Lsdk/pendo/io/f3/a;", "b", "Lsdk/pendo/io/f3/a;", "c", "()Lsdk/pendo/io/f3/a;", "scope", "Lsdk/pendo/io/c3/a;", "Lsdk/pendo/io/c3/a;", "()Lsdk/pendo/io/c3/a;", "parameters", "<init>", "(Lsdk/pendo/io/a3/c;Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.c logger;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.f3.a scope;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.c3.a parameters;

    public b(sdk.pendo.io.a3.c logger, sdk.pendo.io.f3.a scope, sdk.pendo.io.c3.a aVar) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.logger = logger;
        this.scope = scope;
        this.parameters = aVar;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final sdk.pendo.io.a3.c getLogger() {
        return this.logger;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.c3.a getParameters() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final sdk.pendo.io.f3.a getScope() {
        return this.scope;
    }

    public /* synthetic */ b(sdk.pendo.io.a3.c cVar, sdk.pendo.io.f3.a aVar, sdk.pendo.io.c3.a aVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, aVar, (i & 4) != 0 ? null : aVar2);
    }
}
