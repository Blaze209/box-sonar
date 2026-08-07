package sdk.pendo.io.b3;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.z2.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a \u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0001\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/z2/c;", "factory", "", "Lexternal/sdk/pendo/io/org/koin/core/definition/IndexKey;", "mapping", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Lsdk/pendo/io/b3/a;", "modules", "", "koin-core"}, k = 2, mv = {1, 9, 0})
public final class b {
    public static final Set<a> a(List<a> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(modules, linkedHashSet);
        return linkedHashSet;
    }

    private static final void a(List<a> list, Set<a> set) {
        for (a aVar : list) {
            set.add(aVar);
            a(aVar.b(), set);
        }
    }

    public static final void a(c<?> factory, String mapping) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new sdk.pendo.io.x2.b("Already existing definition for " + factory.a() + " at " + mapping);
    }
}
