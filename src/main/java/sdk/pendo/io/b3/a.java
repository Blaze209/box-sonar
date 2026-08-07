package sdk.pendo.io.b3;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.z2.c;
import sdk.pendo.io.z2.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b4\u00105J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0007J \u0010\u0005\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016R \u0010\u0015\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019RZ\u0010#\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u001c2\u001e\u0010\u001d\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u001bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u001c8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0005\u0010 \"\u0004\b!\u0010\"RL\u0010*\u001a.\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020$j\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002`%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b)\u0010\u0014\u001a\u0004\b\u001e\u0010(R0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0\u001bj\b\u0012\u0004\u0012\u00020+`\u001c8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u0012\u0004\b,\u0010\u0014\u001a\u0004\b&\u0010 R&\u00103\u001a\b\u0012\u0004\u0012\u00020\u00000.8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b2\u0010\u0014\u001a\u0004\b\u0016\u00101¨\u00066"}, d2 = {"Lsdk/pendo/io/b3/a;", "", "Lsdk/pendo/io/z2/c;", "instanceFactory", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/z2/d;", "", "Lexternal/sdk/pendo/io/org/koin/core/definition/IndexKey;", "mapping", "factory", "other", "", "equals", "", "hashCode", "Z", "e", "()Z", "get_createdAtStart$annotations", "()V", "_createdAtStart", "b", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "<set-?>", "c", "Ljava/util/HashSet;", "()Ljava/util/HashSet;", "setEagerInstances$koin_core", "(Ljava/util/HashSet;)V", "eagerInstances", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "getMappings$annotations", "mappings", "Lsdk/pendo/io/d3/a;", "getScopes$annotations", "scopes", "", "f", "Ljava/util/List;", "()Ljava/util/List;", "getIncludedModules$annotations", "includedModules", "<init>", "(Z)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean _createdAtStart;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String id;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private HashSet<d<?>> eagerInstances;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final HashMap<String, c<?>> mappings;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final HashSet<sdk.pendo.io.d3.a> scopes;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final List<a> includedModules;

    public a() {
        this(false, 1, null);
    }

    public final HashSet<d<?>> a() {
        return this.eagerInstances;
    }

    public final List<a> b() {
        return this.includedModules;
    }

    public final HashMap<String, c<?>> c() {
        return this.mappings;
    }

    public final HashSet<sdk.pendo.io.d3.a> d() {
        return this.scopes;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean get_createdAtStart() {
        return this._createdAtStart;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && a.class == other.getClass() && Intrinsics.areEqual(this.id, ((a) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public a(boolean z) {
        this._createdAtStart = z;
        this.id = sdk.pendo.io.i3.b.a.b();
        this.eagerInstances = new HashSet<>();
        this.mappings = new HashMap<>();
        this.scopes = new HashSet<>();
        this.includedModules = new ArrayList();
    }

    public final void a(c<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        sdk.pendo.io.w2.a<?> aVarA = instanceFactory.a();
        a(sdk.pendo.io.w2.b.a(aVarA.b(), aVarA.getQualifier(), aVarA.getScopeQualifier()), instanceFactory);
    }

    public /* synthetic */ a(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final void a(d<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        this.eagerInstances.add(instanceFactory);
    }

    public final void a(String mapping, c<?> factory) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mappings.put(mapping, factory);
    }
}
