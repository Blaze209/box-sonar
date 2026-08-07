package sdk.pendo.io.v6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/v6/j;", "", "state", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j {
    public static final j a = new j();

    private j() {
    }

    public final void a(Object state) {
        Intrinsics.checkNotNullParameter(state, "state");
        sdk.pendo.io.x6.d dVarZ = PendoInternal.z();
        e eVar = dVarZ instanceof e ? (e) dVarZ : null;
        if (eVar != null) {
            eVar.a(state);
        }
    }
}
