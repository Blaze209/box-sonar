package sdk.pendo.io.w2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/w2/e;", "R", "", "", "toString", "", "hashCode", "other", "", "equals", "Lsdk/pendo/io/b3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/b3/a;", "getModule", "()Lsdk/pendo/io/b3/a;", "module", "Lsdk/pendo/io/z2/c;", "b", "Lsdk/pendo/io/z2/c;", "getFactory", "()Lsdk/pendo/io/z2/c;", "factory", "<init>", "(Lsdk/pendo/io/b3/a;Lsdk/pendo/io/z2/c;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final /* data */ class e<R> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.b3.a module;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.z2.c<R> factory;

    public e(sdk.pendo.io.b3.a module, sdk.pendo.io.z2.c<R> factory) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.module = module;
        this.factory = factory;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return Intrinsics.areEqual(this.module, eVar.module) && Intrinsics.areEqual(this.factory, eVar.factory);
    }

    public int hashCode() {
        return (this.module.hashCode() * 31) + this.factory.hashCode();
    }

    public String toString() {
        return "KoinDefinition(module=" + this.module + ", factory=" + this.factory + ')';
    }
}
