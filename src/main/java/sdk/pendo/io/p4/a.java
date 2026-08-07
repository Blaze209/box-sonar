package sdk.pendo.io.p4;

import android.os.Looper;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.o3.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/k3/o;", "observer", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class a {
    public static final boolean a(o<?> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            return true;
        }
        observer.onSubscribe(c.b());
        observer.onError(new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName()));
        return false;
    }
}
