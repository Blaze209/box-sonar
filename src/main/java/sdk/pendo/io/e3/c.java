package sdk.pendo.io.e3;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001d\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000e\u0010\u001a¨\u0006!"}, d2 = {"Lsdk/pendo/io/e3/c;", "", "Lsdk/pendo/io/b3/a;", "module", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "modules", "Lsdk/pendo/io/u2/a;", "Lsdk/pendo/io/u2/a;", "_koin", "Ljava/util/HashSet;", "Lsdk/pendo/io/d3/a;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "_scopeDefinitions", "", "", "Lexternal/sdk/pendo/io/org/koin/core/scope/ScopeID;", "Lsdk/pendo/io/f3/a;", "c", "Ljava/util/Map;", "_scopes", "d", "Lsdk/pendo/io/f3/a;", "()Lsdk/pendo/io/f3/a;", "getRootScope$annotations", "()V", "rootScope", "<init>", "(Lsdk/pendo/io/u2/a;)V", "e", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class c {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final sdk.pendo.io.d3.c f = sdk.pendo.io.d3.b.a("_root_");

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.u2.a _koin;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final HashSet<sdk.pendo.io.d3.a> _scopeDefinitions;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, sdk.pendo.io.f3.a> _scopes;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.f3.a rootScope;

    /* JADX INFO: renamed from: sdk.pendo.io.e3.c$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e3/c$a;", "", "Lsdk/pendo/io/d3/c;", "rootScopeQualifier", "Lsdk/pendo/io/d3/c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/d3/c;", "getRootScopeQualifier$annotations", "()V", "", "ROOT_SCOPE_ID", "Ljava/lang/String;", "<init>", "koin-core"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final sdk.pendo.io.d3.c a() {
            return c.f;
        }
    }

    public c(sdk.pendo.io.u2.a _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        HashSet<sdk.pendo.io.d3.a> hashSet = new HashSet<>();
        this._scopeDefinitions = hashSet;
        Map<String, sdk.pendo.io.f3.a> mapC = sdk.pendo.io.i3.b.a.c();
        this._scopes = mapC;
        sdk.pendo.io.f3.a aVar = new sdk.pendo.io.f3.a(f, "_root_", true, _koin);
        this.rootScope = aVar;
        hashSet.add(aVar.getScopeQualifier());
        mapC.put(aVar.getId(), aVar);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.f3.a getRootScope() {
        return this.rootScope;
    }

    private final void a(sdk.pendo.io.b3.a module) {
        this._scopeDefinitions.addAll(module.d());
    }

    public final void a(Set<sdk.pendo.io.b3.a> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator<T> it = modules.iterator();
        while (it.hasNext()) {
            a((sdk.pendo.io.b3.a) it.next());
        }
    }
}
